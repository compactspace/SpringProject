package com.spring.finall.aop;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;


public class Ex02Main {

	public static void main(String[] args)  {
		ApplicationContext ctx=new GenericXmlApplicationContext("aop2x01.xml");
		Transaction target =(Transaction) ctx.getBean("transaction");
		target.x();
		
	}

}
