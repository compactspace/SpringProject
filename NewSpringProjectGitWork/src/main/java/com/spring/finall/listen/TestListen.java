//package com.spring.finall.listen;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
////ServletContextListener 확인용 클래스임 의미는 없음.
//@WebListener
//public class TestListen implements ServletContextListener {
//
//	public TestListen() {
//
//		System.out.println("리스너구현 클래스 생성됨");
//
//	}
//
//	@Override
//	public void contextInitialized(ServletContextEvent sce) {
//		System.out.println("초기화진행중");
//		ServletContext sct = sce.getServletContext();
//
//		try {
//			sct.setAttribute("ses", "ping");
//		} catch (Exception e) {
//
//			System.out.println(e);
//
//		}
//
//	}
//
//	@Override
//	public void contextDestroyed(ServletContextEvent sce) {
//		ServletContext sct = sce.getServletContext();
//		System.out.println("파괴됨");
//
//		sct.removeAttribute("end");
//
//	}
//
//}
