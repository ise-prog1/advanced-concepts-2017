package producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

	private BlockingQueue<String> queue;
	private Random random = new Random();
	private int runCounter = 0;

	public Producer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			boolean head = random.nextBoolean();
			if (head) {
				// Blocks until adding is possible
				// See JavaDoc for BlockingQueue
				queue.offer("Kopf");
			} else {
				queue.offer("Zahl");
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// restore interrupt flag
				Thread.currentThread().interrupt();
			}
			runCounter++;
		}
		System.out.println("Producer runs: " + runCounter);
	}
}
