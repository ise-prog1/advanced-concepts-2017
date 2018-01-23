package queue;

/**
 * This exceptions represents the error of a full queue
 */
public class QueueFullException extends Exception {

	public QueueFullException() {
		super();
	}

	public QueueFullException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueueFullException(String message) {
		super(message);
	}

	public QueueFullException(Throwable cause) {
		super(cause);
	}

}
