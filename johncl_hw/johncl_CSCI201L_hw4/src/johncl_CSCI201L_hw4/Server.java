package johncl_CSCI201L_hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class Server {
	private Vector<ServThread> serverThreads = new Vector<ServThread>();
	private Vector<Lock> locks;
	private Vector<Condition> conditions;
//	private Vector<String> board;
	private static int num_p = 0; //Number of players
	private static int playerNum = 1;
	private int lock_index = 0;
	private int st_index = 0;
	public Board GameBoard;
	public boolean P1 = true;
	
	public void signal() {
		if(lock_index==locks.size()) lock_index=0;
		else lock_index++;
		locks.get(lock_index).lock();
		conditions.get(lock_index).signalAll();
		locks.get(lock_index).unlock();
		System.out.println("Switching Player...");
	}
	
	public Server(int port) {
		locks=new Vector<Lock>();
		conditions=new Vector<Condition>();
		BufferedReader br = null;
		PrintWriter pw;
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Listening on port " + port);
			System.out.println("Waiting for players...");
			//Waits for player to join		
			while(true) {
				Socket s = ss.accept();
				System.out.println("Connection from " + s.getInetAddress());//Get IP address
				if(playerNum > 1) {
					broadCastJoin();//When player 2 joins
				}
				Lock lock = new ReentrantLock();
				Condition TurnEnd = lock.newCondition();
				//Add ServerThread at its designated spot
				
				if(serverThreads.size() > 0) {
					P1 = false;
				}
				ServThread st = new ServThread(s, this, lock, TurnEnd, P1);
				serverThreads.add(st);
				playerNum++;
				st_index++;					
				//Create lock and condition
				locks.add(lock);
				conditions.add(TurnEnd);
				//File Read if all players joined execute this block
//				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//				String st_msg = br.readLine();
				if( num_p == playerNum ) { //st_msg.equals("Start game")
					System.out.println("Game can now begin.");
					String begin_msg = "The game is beginning";
					broadCastMsg(begin_msg);
					System.out.println("Sending game board");
					GameBoard = new Board();
					String gameboardMsg = GameBoard.printBoardMsg();
					broadCastBoard(gameboardMsg);
				}
			}
		} catch (IOException ioe) {
			System.out.println("ioe = " + ioe.getMessage());
		}
	}
	public void broadcastMove(String line, ServThread currentST) {
		if(line != null && line.trim().length() > 0)
		System.out.println(line);
		for(ServThread st: serverThreads) {
			if(st != currentST) {
				st.sendMessage(line);
			}
		}
	}
	public void broadCastBoard(String line) {
		for(ServThread st: serverThreads) {
			st.sendMessage(line);
		}
	}
	public void broadCastMsg(String msg) {
		for(ServThread st: serverThreads) {
			st.sendMessage(msg);
		}
	}
	public void broadCastJoin() {
		for(ServThread st: serverThreads) {
			st.sendMessage("Player " + playerNum + " has joined from 127.0.0.1");
		}
	}
	public static void main(String[] args) {
		Server cr = new Server(3456);
	}
}
