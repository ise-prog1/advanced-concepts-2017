package producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {

	
	public static void main(String[] args) throws InterruptedException {
		// Coding to an Interface, prefer an Interface as a variable type!
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		p.start();
		c.start();
		
		Thread.sleep(10_000);
		p.interrupt();
		c.interrupt();
	}
}
