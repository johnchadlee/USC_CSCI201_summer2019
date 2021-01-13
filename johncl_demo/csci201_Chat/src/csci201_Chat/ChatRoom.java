package csci201_Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatRoom {
	private Vector<ServerThread> serverThreads = new Vector<ServerThread>();
	public ChatRoom(int port) {
		try {
			//No other program can listen to the port
			//Until you release it
			System.out.println("Binding to port " + port);
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Bound to port " + port);//If we get here, we are bound to the port, so print
			//Blocking line of code, 
			//my code will wait on that line until something happens
			//Wait for client to connect to me
			while(true) {
				Socket s = ss.accept();
				System.out.println("Connection from " + s.getInetAddress());
				ServerThread st = new ServerThread(s, this);//Start the thread in the constructor
				serverThreads.add(st);
			}
		} catch (IOException ioe) {
			System.out.println("ioe = " + ioe.getMessage());
		}
	}
	public void broadcastLine(String line, ServerThread currentST) {
		if(line != null && line.trim().length() > 0)
		System.out.println(line);
		for(ServerThread st: serverThreads) {
			if(st != currentST) {
				st.sendMessage(line);
			}
		}
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ChatRoom cr = new ChatRoom(6789);
	}
}
//InputStreamReader isr = new InputStreamReader(s.getInputStream());//Reads byte
//BufferedReader br = new BufferedReader(isr);//Reads string
//PrintWriter pw = new PrintWriter(s.getOutputStream()); //Send string back to client			
//String line = br.readLine();
//System.out.println("Client sent: " + line);
//pw.println("Thanks for sending me a message!");
//VERY IMPORTANT!!!!!!
//Sending something to the socket is expensive(slow)
//Not actually taking the string immediately
//Write string into buffer
//Not going to send the message until the buffer fill up
//Whatever is in the buffer gets sent right away with flush()
//pw.flush();
//br.close();
//pw.close();
//s.close();
//ss.close();
