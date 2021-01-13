package johncl_CSCI201L_lab10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageTest {
	public static void main(String[] args) {
		for(int i =0; i<10; i++) {
			MessageQueue myq = new MessageQueue();
			Messenger mes = new Messenger(myq);
			Subscriber sub = new Subscriber(myq);
			ExecutorService executor = Executors.newFixedThreadPool(2);
			executor.execute(mes);
			executor.execute(sub);
			executor.shutdown(); //No new task will be accepted
			while(!executor.isTerminated()) {
				Thread.yield();
			}
		}
	}
}
