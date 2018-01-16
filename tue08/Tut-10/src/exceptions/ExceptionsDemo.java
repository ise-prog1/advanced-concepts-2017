package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ExceptionsDemo {

	public static void checkedException() throws IOException {
		throw new IOException();
	}

	public static void main(String[] args) throws IOException {
		// checkedException();
		int res = addPositive(2, 3);
		System.out.println(res);
		try {
			fileExceptions();
		} catch (FileAlreadyExistsException | FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			fileExceptions();
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Fehler!!!!!");
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}
		System.out.println("Programm Ende");
	}

	/**
	 * @throws Might
	 *             throw a NullPointerException
	 */
	public static void uncheckedException() {
		throw new NullPointerException();
	}

	public static int addPositive(int a, int b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Parameter is negative");
		}
		return a + b;
	}

	public static void fileExceptions() throws FileAlreadyExistsException, FileNotFoundException {
		if (Math.random() < 0.5) {
			throw new FileAlreadyExistsException("bla");
		} else {
			throw new FileNotFoundException("not found");
		}
	}
}
