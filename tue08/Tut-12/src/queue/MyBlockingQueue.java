package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * This class offers a blocking queue with a default limit of 10.
 *
 * @param <T>
 */
public class MyBlockingQueue<T> {

	private List<T> backend = new ArrayList<>();
	private int limit = 10;
	
	
	public MyBlockingQueue() {
		super();
	}

	public MyBlockingQueue(int limit) {
		super();
		this.limit = limit;
	}

	public synchronized T dequeue() throws InterruptedException {
		while (this.backend.size() == 0) {
			wait();
		}
		if (this.backend.size() == this.limit) {
			// somebody is waiting to enqueue
			notifyAll();
		}
		
		return this.backend.remove(0);

	}

	public synchronized void enqueue(T element) throws InterruptedException {
		
		while (this.backend.size() == this.limit) {
			wait();
		}
		if (this.backend.size() == 0) {
			// somebody is waiting to dequeue
			notifyAll();
		}
		this.backend.add(element);

	}
}
