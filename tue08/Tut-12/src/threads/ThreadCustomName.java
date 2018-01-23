package threads;

public class ThreadCustomName implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new ThreadCustomName(), "Custom");
		Thread t1 = new Thread(new ThreadCustomName(), "Custom");
		t1.setName("Set Name");
		t.start();
		t1.start();
		// wait at most 100 ms for Thread to finish
		t.join(100);
		if (t.isAlive())
			System.out.println("Thread is still alive!");
		// wait indefinitely for Thread to finish
		t.join(0);
		t1.join();
	}
}
