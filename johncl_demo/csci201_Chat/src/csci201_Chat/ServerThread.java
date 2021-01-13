package csci201_Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private BufferedReader br;
	private PrintWriter pw;
	private ChatRoom cr;
	
	public ServerThread(Socket s, ChatRoom cr){
		try {
			this.cr = cr;
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			this.br = new BufferedReader(isr);
			this.pw = new PrintWriter(s.getOutputStream());
			this.start();//Put it into start state
		}
		catch(IOException ioe) {
			System.out.println("Ioe in ServerThread: " + ioe.getMessage());
		}
	} 
	public void sendMessage(String line) {
		pw.println(line);
		pw.flush();
	}
	public void run() {
		try {
			while(true) {
				String line = br.readLine();
				cr.broadcastLine(line, this);
			}
		} catch(IOException ioe) {
			System.out.println("ioe in ServerThread.run(): " + ioe.getMessage());
		}
	}

}

