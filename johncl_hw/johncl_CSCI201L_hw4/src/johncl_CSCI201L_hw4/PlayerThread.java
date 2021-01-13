package johncl_CSCI201L_hw4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PlayerThread extends Thread{
	private BufferedReader br;
	private PrintWriter pw;
	private boolean Player1 = true;
	
	public PlayerThread(String hostname,int port) {
		try {
			Socket s = new Socket(hostname, port);
			Scanner scan = new Scanner(System.in);
			//This block should only run once
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
			this.start();
			while(true) {
				if(Player1 == true) {
//					System.out.println("How many players will there be? ");
					String line = scan.nextLine();//blocking call, wait on this line
					int n = Integer.parseInt(line);
					if(n <= 3 && n > 0) {
						pw.println(line);
						pw.flush();
						Player1 = false;
						break;
					}
				}
				else {
					System.out.println("There is a game waiting for you.\n" + 
							"Player 1 has already joined.");
					String line = "Start game";//Start Game
					pw.println(line);
					pw.flush();
				}
			}
		} catch(IOException ioe) {
			System.out.println("ioe = " + ioe.getMessage());
		}
	}
	public void run() {
		try {
			while(true) {
				String msg = br.readLine();
				System.out.println(msg);
			} 
		}catch (IOException ioe) {
			System.out.println("ioe in ChatClient.run(): " + ioe.getMessage() );
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to 201 Crossword!");//Welcome message
		String hostname = "localhost";
		int port = 3456;
		Scanner scan = new Scanner(System.in);
		boolean Host_validated = false;
		while(!Host_validated) {
			System.out.println("Enter the server hostname: ");
			String host = scan.nextLine();
			if(host.equals(hostname) ) {
				break;
			}
		}
		boolean Port_validated = false;
		while(!Port_validated) {
			System.out.println("Enter the server port: ");
			int p = Integer.parseInt(scan.nextLine());
			if(p == port) {
				break;
			}
		}
		//Create Player
		PlayerThread cc = new PlayerThread(hostname, port);	//"192.168.1.120"
	}

}
