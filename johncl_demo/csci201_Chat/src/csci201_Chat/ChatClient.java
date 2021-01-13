package csci201_Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread{
	
	private BufferedReader br;
	private PrintWriter pw;
	public ChatClient(String hostname, int port) {
		try {
			System.out.println("Trying to connect to " + hostname + ":" + port);
			@SuppressWarnings("resource")
			Socket s = new Socket(hostname, port);
			System.out.println("Connected to " + hostname + ":" + port);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
			this.start();
			Scanner scan = new Scanner(System.in);
			while(true) {
				String line = scan.nextLine();//blocking call, wait on this line
				pw.println("ME: " + line);
				pw.flush();
			}
		} catch(IOException ioe) {
			System.out.println("ioe = " + ioe.getMessage());
		}
	}
	public void run() {
		try {
			while(true) {
				String line = br.readLine();
				System.out.println(line);
			} 
		}catch (IOException ioe) {
			System.out.println("ioe in ChatClient.run(): " + ioe.getMessage() );
		}
	}
	public static void main(String[] args) {
		
		ChatClient cc = new ChatClient("localhost", 6789);	//"192.168.1.120"
	}
}
//CHECKER
//pw.println("Here is my message!");
//pw.flush();
//String line = br.readLine();
//System.out.println("Recieved from server: " + line);
//br.close();
//pw.close();
//s.close();