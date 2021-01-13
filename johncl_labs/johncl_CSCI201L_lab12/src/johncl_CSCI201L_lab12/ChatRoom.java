package johncl_CSCI201L_lab12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChatRoom {
	private Vector<ServerThread> serverThreads;
	private Vector<Lock> locks;
	private Vector<Condition> conditions;
	private int i=0;
	public void signal() {
		if(i==locks.size()) i=0;
		else i++;
		locks.get(i).lock();
		conditions.get(i).signalAll();
		locks.get(i).unlock();
		System.out.println("Switching users...");
	}
	public ChatRoom(int port) {
		locks=new Vector<Lock>();
		conditions=new Vector<Condition>();
		try {
			System.out.println("Binding to port " + port);
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Bound to port " + port);
			serverThreads = new Vector<ServerThread>();
			while(true) {
				Socket s = ss.accept(); // blocking
				System.out.println("Connection from: " + s.getInetAddress());
				Lock lock = new ReentrantLock();
				Condition messageEnd = lock.newCondition();
				ServerThread st;
				if(serverThreads.size()==0) {
					st = new ServerThread(s, this, lock, messageEnd, true);
				}
				else st=new ServerThread(s, this, lock, messageEnd, false);
				serverThreads.add(st);
				locks.add(lock);
				conditions.add(messageEnd);
			}
		} catch (IOException ioe) {
			System.out.println("ioe in ChatRoom constructor: " + ioe.getMessage());
		}
	}
	
	public void broadcast(String message, ServerThread st) {
		if (message!=null && message!= "END_OF_MESSAGE") {
			System.out.println("broadcasting: "+message);
			for(ServerThread threads : serverThreads) {
				if (st != threads) {
					threads.sendMessage(message);
				}
			}
		}
	}
	public static void main(String [] args) {
		ChatRoom cr = new ChatRoom(6789);
	}
}
