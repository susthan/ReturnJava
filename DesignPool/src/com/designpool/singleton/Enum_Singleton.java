package com.designpool.singleton;

/**
 *  Immune to reflection attack
 *
 */
public enum Enum_Singleton {
	
	INSTANCE;				// Used for singleton, must not add another ENUM
	
	private String string = "I am solo!";
	
	public void doSomething() {
		System.out.println(string);
	}
	
}
