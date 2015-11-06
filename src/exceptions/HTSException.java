package exceptions;

@SuppressWarnings("serial")
public class HTSException extends Exception{
	String Message;

	public HTSException(String message) {
		Message = message;
	}

}
