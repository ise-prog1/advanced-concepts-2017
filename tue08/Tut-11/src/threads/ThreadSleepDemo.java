package threads;

public class ThreadSleepDemo implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("i: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Schlaf unterbrochen!");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread sleeper = new Thread(new ThreadSleepDemo());
		sleeper.start();
		Thread.sleep(5000);
		sleeper.interrupt();
	}
	
}
