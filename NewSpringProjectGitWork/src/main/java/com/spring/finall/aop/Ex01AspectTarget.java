package com.spring.finall.aop;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;



public class Ex01AspectTarget {
	
	
	public void Target() {
		System.out.println("타겟메소드는 나누기"+3/2);
		
	}
	
	

}
