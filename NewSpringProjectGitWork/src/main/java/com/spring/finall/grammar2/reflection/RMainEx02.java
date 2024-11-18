package com.spring.finall.grammar2.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RMainEx02 {

	public static void main(String[] args) throws Exception {
		
		Class<?> cls = Class.forName("reflection.ReflectionEx02");
		
		Constructor<?> ct =cls.getConstructor(null);
		
		Object obj =ct.newInstance(args);
		
		Method m =cls.getMethod(null, null);
		

	}

}
