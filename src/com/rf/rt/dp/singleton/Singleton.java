package com.rf.rt.dp.singleton;

import java.io.Serializable;

public final class Singleton implements Cloneable, Serializable {

	private static final long serialVersionUID = -6320769140102819637L;

	/**
	 * Ensures that changes made by one thread to instance are immediately visible
	 * to all other threads
	 */
	private static volatile Singleton instance;

	/**
	 * Protect against reflection attack
	 */
	private Singleton() {
		if (instance != null) {
			throw new IllegalStateException("Instance already created.");
		}
	}

	/**
	 * Double-Checked Locking for optimal performance and thread safety
	 * 
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					System.out.println("Object created.. " + Thread.currentThread().getName());
					instance = new Singleton();
				}
			}
		}

		System.out.println(instance + " --> " + Thread.currentThread().getName());

		return instance;
	}

	/**
	 * Prevent from deserialization
	 * 
	 * @return
	 */
	private Object readResolve() {
		return getInstance();
	}

	/**
	 * Prevent from cloning
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone not possible..");
	}

}

/**
 * Main method
 */
class Main {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(Singleton::getInstance);
			thread.start();
		}
	}
}
