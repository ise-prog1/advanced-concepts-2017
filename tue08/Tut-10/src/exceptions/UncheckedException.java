package exceptions;
/**
 * How to create your own UncheckedException:
 * Simply extends RuntimeException
 */
public class UncheckedException extends RuntimeException {

	public UncheckedException() {
		super();
	}
	
	public UncheckedException(String message) {
		super(message);
	}
	
	public UncheckedException(String message, Throwable cause) {
		super(message, cause);
	}
}
