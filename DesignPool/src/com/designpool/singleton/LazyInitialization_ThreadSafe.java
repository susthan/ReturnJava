package com.designpool.singleton;

/**
 * Susceptible to reflection attack
 *
 */
public class LazyInitialization_ThreadSafe {

	private static LazyInitialization_ThreadSafe instance ;
	
	private LazyInitialization_ThreadSafe() {
		// Do something
	}
	
	public static LazyInitialization_ThreadSafe getInstance() {
		if(instance == null) {
			synchronized (LazyInitialization_ThreadSafe.class) {
				if(instance == null)
					instance = new LazyInitialization_ThreadSafe();
			}
		}
		return instance;
	}

}
