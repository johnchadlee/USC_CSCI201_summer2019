package johncl_CSCI201L_lab12;


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ServerThread extends Thread {

	private PrintWriter pw;
	private BufferedReader br;
	private ChatRoom cr;
	private Lock _lock;
	private Condition _messageEnd;
	private boolean first=false;
	public ServerThread(Socket s, ChatRoom cr, Lock lock, Condition messageEnd, boolean isfirst) {
		_lock=lock;
		_messageEnd=messageEnd;
		first=isfirst;
		try {
			this.cr = cr;
			pw = new PrintWriter(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			this.start();
		} catch (IOException ioe) {
			System.out.println("ioe in ServerThread constructor: " + ioe.getMessage());
		}
	}

	public void sendMessage(String message) {
		pw.println(message);
		pw.flush();
	}
	
	public void run() {
		try {
			while(true) {
				_lock.lock();
				if(!first) _messageEnd.await();
				else first=false;
				
				String line=br.readLine();
				while(line!="END_OF_MESSAGE") {
					System.out.println("line: "+line);
					cr.broadcast(line, this);
					line=br.readLine();
				}
				System.out.println("message ended");
				cr.signal();
			}
		} catch (IOException ioe) {
			System.out.println("ioe in ServerThread.run(): " + ioe.getMessage());
		} catch (InterruptedException ie) {
			System.out.println("ie: "+ie.getMessage());
		}
	}
}
