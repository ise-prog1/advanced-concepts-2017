package threads;

public class RunnableDemo implements Runnable {
	
	Runnable runnableLambda = () -> System.out.println(Thread.currentThread().getName());
	

	public static void main(String[] args) {
		new Thread(new RunnableDemo()).start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
