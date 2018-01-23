package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	private BlockingQueue<String> queue;
	private int heads = 0;
	private int total = 0;
	
	private int runCounter = 0;
	
	public Consumer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				// Blocks until taking is possible
				// See JavaDoc for BlockingQueue
				String value = this.queue.take();
				total++;
				if (value.equals("Kopf")) {
					heads++;
				}
				System.out.println("Percentage of heads: " + ((double) heads / total));
				runCounter++;
			} catch (InterruptedException e) {
				// restore interrupt flag
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Consumer runs: " + runCounter);
	}
}
