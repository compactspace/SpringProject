package com.spring.finall.grammar2;

public class StringEx01 {

	public static void main(String[] args) {
		 
		String str1="하하";
		
		System.out.println(System.identityHashCode(str1));
		
		str1=str1+"두번째 추가";
		
		System.out.println(System.identityHashCode(str1));
		
		
	}

}
