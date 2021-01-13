package johncl_CSCI201L_lab10;

import java.util.ArrayDeque;
import java.util.Queue;

public class MessageQueue {
	
	private Queue<String> q;
	
	//Constructor
	public MessageQueue() {
		q = new ArrayDeque<String>();
	}
	public void addMessage(String s) {
		q.add(s);
	}
	public String getMessage() {
		if(q.isEmpty()) {
			return null;
		}
		String message = "";
		message = q.peek();
		q.remove();
		return message;
	}
}
