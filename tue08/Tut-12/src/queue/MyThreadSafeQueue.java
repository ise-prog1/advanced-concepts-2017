package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * This class offers a Thread safe queue with a limit of 10.
 *
 * @param <T>
 */
public class MyThreadSafeQueue<T> {

	List<T> backend = new ArrayList<>();

	public T dequeue() {
		synchronized (backend) {
			if (backend.size() == 0) {
				return null;
			}

			T result = backend.get(0);
			backend.remove(0);
			return result;
		}
	}

	public void enqueue(T element) throws QueueFullException {
		synchronized (backend) {
			if (backend.size() == 10)
				throw new QueueFullException("Queue ist voll!");
			backend.add(element);
		}
	}
}
