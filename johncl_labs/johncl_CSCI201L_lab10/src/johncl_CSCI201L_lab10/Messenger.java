package johncl_CSCI201L_lab10;

import java.util.Date;
import java.util.Random;

public class Messenger extends Thread {
	
	private MessageQueue q;
	
	//Constructor
	public Messenger(MessageQueue que){
		q= que;
	}
	public void run() {
		for(int i =1; i<=20; i++) {
			String line = "Message #" + i;
			System.out.println(line + " sent at " + new Date().toString() );
			q.addMessage(line);
			Random r = new Random();
			try {
				System.out.println("Messenger asleep");
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
