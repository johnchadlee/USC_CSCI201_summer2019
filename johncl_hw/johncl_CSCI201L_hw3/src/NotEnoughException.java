
public class NotEnoughException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "There are not enough parameters on line \'";
	public String getMessage() {
		return message;
	}
	public void addToMessage(String line) {
		message += line;
		message += "\'.\n";
	}
}