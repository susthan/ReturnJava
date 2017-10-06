package com.designpool.singleton;

/**
 * Thread safe without Synchronization
 * 
 *Susceptible to reflection attack
 */
public class LazyInitialization_BillPugh {

	private LazyInitialization_BillPugh() {
		// Do something
	}
	
	private static class SingletonHelper{
		private static final LazyInitialization_BillPugh INSTANCE = new LazyInitialization_BillPugh();
	}
	
	public static LazyInitialization_BillPugh getInstance() {
		return SingletonHelper.INSTANCE;
	}

}
