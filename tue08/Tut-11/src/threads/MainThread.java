package threads;

public class MainThread {

	public static void main(String[] args) {
		// The main method gets run on a Thread called "main"
		String name = Thread.currentThread().getName();
		System.out.println(name);
	}
}
