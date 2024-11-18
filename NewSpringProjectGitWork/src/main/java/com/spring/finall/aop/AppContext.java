package com.spring.finall.aop;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Ex01AspectTarget EX01ASPECTTARGET() {
		Ex01AspectTarget target = new Ex01AspectTarget();
		System.out.println();

		return target;
	}

	@Bean
	public Ex01Aspect EX01ASPECT() {

		Ex01Aspect aspect = new Ex01Aspect();

		return aspect;
	}

}
