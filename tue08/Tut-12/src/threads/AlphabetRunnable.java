package threads;

public class AlphabetRunnable implements Runnable {

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("a");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				// restore interrupt flag
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Fertig!");
	}
	// Thread.currentThread().isInterrupted() - does not touch the interrupt flag
	// Thread.interrupted() -- class method - resets the interrupt flag
	// -> take Thread.currentThread().isInterrupted()
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new AlphabetRunnable(), "Alphabet");
		t.start();
		t.join(1000); // wait at most 1000 ms for termination
		// interrupt if still alive
		if (t.isAlive())
			t.interrupt();
		
	}
}
