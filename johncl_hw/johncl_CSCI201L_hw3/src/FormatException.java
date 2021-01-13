
public class FormatException extends NumberFormatException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message = "Unable to convert \'";
	public void addFloatExceptionMessage() {
		message += "\' to a float.\n";
	}
	public void addIntExceptionMessage() {
		message += "\' to an int.\n";
	}
	public void addDoubleExceptionMessage() {
		message += "\' to a double.\n";
	}
	public String getMessage() {
		return message;
	}
	public void addToMessage(String line) {
		message += line;
	}
}