package com.designpool.singleton;

/**
 * Susceptible to reflection attack
 *
 */
public class EagerInitialization {

	// Use static block in case the constructor throws Exception. 
	private static final EagerInitialization INSTANCE = new EagerInitialization();
	
	private EagerInitialization() {
		//Do something
	}
	
	public static EagerInitialization getInstance() {
		return INSTANCE;
	}

}
