package singleton;

/**
 * You can also create a singleton as an Enum
 * This way is even reflection proof.
 * This should be the preferred way to create a Singleton.
 * See Effective Java by Joshua Block (2nd edition / 3rd edition) item 4
 */
public enum SingletonEnum {
	INSTANCE;
	
}
