package threads;

public class ThreadSleepBetterDemo implements Runnable {

	@Override
	public void run() {
		System.out.println("Starting Thread...");
		try {
			for (int i = 0; i < 25; i++) {
				System.out.println("i: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread unterbrochen!");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hi");
		Thread sleeper = new Thread(new ThreadSleepBetterDemo());
		sleeper.start();
		Thread.sleep(2500);
		// causes the InterruptedException in the other Thread
		sleeper.interrupt();
	}

}
