package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
