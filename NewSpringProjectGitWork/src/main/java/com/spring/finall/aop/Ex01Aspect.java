package com.spring.finall.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect

public class Ex01Aspect {
	 
	

	
	
	@Before("within(com.spring.finall.aop.Ex01AspectTarget)")
	public void beforeMethod() {
		System.out.println("beforeMethod 호출");
	}
	
	// finall 구문 처럼 타겟메소드가 에러이던 뭐던호출
    @After("within(com.spring.finall.aop.Ex01AspectTarget)")
    public void afterMethod() {
    	System.out.println("afterMethod 호출");
    }
	
    //팩트체크함
    //타겟 메소드가 에러일시에만 호출됨
    //Ex01AspectTarget 의 target(){syso(3/0)} 은 에러인데 이때 호출됨
    @AfterThrowing(pointcut="within(com.spring.finall.aop.Ex01AspectTarget)",throwing="e")
    public void afterthrowingMethod(Throwable e) {
    	System.out.println("타겟메소드가 에러일시");
    }

}
