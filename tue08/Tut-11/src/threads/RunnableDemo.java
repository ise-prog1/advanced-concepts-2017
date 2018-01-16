package threads;

/**
 * Option 2 to make something run in parallel:
 * implement Runnable
 * 
 * The other option is to extend Thread (See {@link threads.CounterThread CounterThread})
 */
public class RunnableDemo implements Runnable {
	
	// Runnable declared with a lambda expression
	static Runnable runnableLambda = () -> System.out.println(Thread.currentThread().getName());
	

	public static void main(String[] args) {
		// Start starts a Thread.
		// Thread(Runnable r) constructors are used here
		new Thread(new RunnableDemo()).start();
		new Thread(runnableLambda).start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
