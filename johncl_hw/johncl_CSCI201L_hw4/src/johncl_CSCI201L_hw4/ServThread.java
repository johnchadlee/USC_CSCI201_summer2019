package johncl_CSCI201L_hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ServThread extends Thread{
	private BufferedReader br;
	private PrintWriter pw;
	private Server ser;
	private Lock LOCK;
	private Condition _TurnEnd;
	public boolean Player1 = true;
	private int Pnum = 0;
	private int playerNum = 2;
	PlayerThread pt;
	
	public ServThread(Socket s, Server ser, Lock lock, Condition TurnEnd, boolean P1){
		LOCK = lock;
		_TurnEnd = TurnEnd;
		try {
			this.ser = ser;
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			this.br = new BufferedReader(isr);
			this.pw = new PrintWriter(s.getOutputStream());
			Player1 = P1;
			this.start();//Put Thread into start state
		}
		catch(IOException ioe) {
			System.out.println("IOE in ServerThread: " + ioe.getMessage());
		}
	} 
	public void sendMessage(String line) {
		pw.println(line);
		pw.flush();
	}
	public void run() {
		try {
			while(true) {
				LOCK.lock();
				if(Player1 == true) { //Player 1 condition
					sendMessage("How many players will there be?");
					Pnum = Integer.parseInt(br.readLine());//Receive input from Player & Update number of players
					System.out.println("Number of players selected: " + Pnum);
					System.out.println("Waiting for player 2");
					sendMessage("Waiting for player " + playerNum);
					System.out.println("Reading random game file.\n" + 
							"File read successfully.");
					_TurnEnd.await();
				}
				else {
					if(Pnum == 3) {
						sendMessage("Waiting for player 3");
					}
					if(Pnum == 2) {
						sendMessage("Waiting for player 2");
					}
					_TurnEnd.await();
				}
				if(playerNum<=Pnum) {
					playerNum++;//Increment player number
				}
				String line = br.readLine();
				ser.broadcastMove(line, this);
				ser.signal();
			}
		} catch(IOException ioe) {
			System.out.println("ioe in ServThread.run(): " + ioe.getMessage());
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception " + e.getMessage());
		}finally {
			LOCK.unlock();
		}
	}

}