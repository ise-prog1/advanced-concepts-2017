package singleton;

/**
 * This class is a demonstration of the Singleton pattern
 * It enables us to only have one instance of a class
 * 
 * This implementation is lazy, as the instance only gets created on the first access
 * of the getter.
 */
public class Singleton {
	
	private static Singleton instance = null;
	
	// private constructor disables construction outside of this class
	private Singleton() {
		
	}

	// getter
	public static Singleton getInstance() {
		// caching of instance creation
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	// instance methods
}
