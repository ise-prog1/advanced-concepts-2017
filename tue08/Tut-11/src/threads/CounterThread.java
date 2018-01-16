package threads;

/**
 * Option 1 to get a Thread:
 * extend it!
 * 
 * The other option is to implement Runnable (See {@link threads.RunnableDemo RunnableDemo})
 */
public class CounterThread extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 11; i++) {
			System.out.println("Hi ich bin " + Thread.currentThread().getName() + " und meine Zahl ist " + i);
		}
	}

	public static void main(String[] args) {
		new CounterThread().start();
		new CounterThread().start();
	}
}
