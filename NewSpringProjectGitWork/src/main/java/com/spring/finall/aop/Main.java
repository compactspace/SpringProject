package com.spring.finall.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//자바 main 기준
		//xml 기반 컨테이너 는
		//1. src/main/resources 경로를 보며 작성한 xml명을기재
		//2. 그 xml에 일일히 bean id class 기재하면됨
		//context:component-scan 필요없음
	ApplicationContext ctx =  new  GenericXmlApplicationContext("aop.xml");
	Ex01AspectTarget target= (Ex01AspectTarget) ctx.getBean("aspecttarget");
	target.Target();
	
	
		
	}

}
