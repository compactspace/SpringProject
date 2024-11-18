//package com.spring.finall.config.Service;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//public class Test {
//
//	public static void main(String[] args) {
//		EntityManagerFactory emf = 
//				Persistence.createEntityManagerFactory("jpa-maria");
//				//System.out.println(emf);
//				ApplicationContext aContext = new GenericXmlApplicationContext("classpath:applicationContext.xml");
//				
//				System.out.println("왓"+aContext.getBean("dataSource"));
//	}
//
//}
