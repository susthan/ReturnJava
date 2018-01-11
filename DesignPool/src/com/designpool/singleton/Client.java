package com.designpool.singleton;

import java.lang.reflect.Constructor;

public class Client {

	public static void test(Class clazz) throws Exception {
		Object obj1 = clazz.getMethod("getInstance").invoke(null);
		Object obj2 = clazz.getMethod("getInstance").invoke(null);
		Object obj3 = breakSingleton(clazz);

		System.out.println("Class under test                                                : "+ clazz.getName());
		System.out.println("Does two instances from getInstance() are same                  : "+obj1.equals(obj2));
		System.out.println("Does instances from getInstance() and breakSingleton() are same : "+obj1.equals(obj3));
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	public static <E> E breakSingleton(Class<E> clazz) {
		E instance = null;
		for(Constructor constructor : clazz.getConstructors()) {
			constructor.setAccessible(true);
			try {
				instance = (E) constructor.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		return instance;
	}

	public static void main(String[] args) {
		try {
			test(LazyInitialization_BillPugh.class);
			test(EagerInitialization.class);
			test(LazyInitialization_ThreadSafe.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
