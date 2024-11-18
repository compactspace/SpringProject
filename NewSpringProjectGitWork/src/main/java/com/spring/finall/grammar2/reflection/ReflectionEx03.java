package com.spring.finall.grammar2.reflection;



public class ReflectionEx03 {
	
	public String x="하하";	
	
	
	public String show() {
		
		return "안녕하십니까";
	}
	
	static {
		
		System.out.println("난 클래스가 로드되기만 하면 출력됨 스테틱 영역임");
		
	}

}
