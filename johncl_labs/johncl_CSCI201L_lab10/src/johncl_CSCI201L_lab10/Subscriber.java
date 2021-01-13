package johncl_CSCI201L_lab10;
import java.util.Date;
import java.util.Random;

public class Subscriber extends Thread{

	private MessageQueue q;
	
	public Subscriber(MessageQueue que){
		q = que;
	}
	public void run() {
		int count = 0;
		while(count < 20) {
			String query = q.getMessage();
			if(query != null && query != "") {
				count++;
				System.out.println(query + " recieved at " + new Date().toString());
			}
			Random r = new Random();
			try {
				System.out.println("Subscriber sleeping");
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		}
	}
}
