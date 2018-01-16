package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class demonstrates a part of the java.util.concurrent package.
 * 
 * These solutions are to be preferred over using your own Threads!
 */
public class ExecutorDemo {
	
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService exe = Executors.newScheduledThreadPool(4);
		long initialDelay = 0L;
		long rate = 1L; 
		exe.scheduleAtFixedRate(() -> System.out.println("hi fixed"), initialDelay, rate, TimeUnit.SECONDS);
		Thread.sleep(5000);
		exe.shutdownNow();
	}
}
