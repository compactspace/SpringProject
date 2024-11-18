package com.spring.finall.grammar2.reflection;

public class RMainEx03 {

	
	public static void main(String[] args) {

		System.out.println("메인 클래스 실행합니다");

		try {
			TestDIClass id=CustomApplicationContext.getInstance(TestDIClass.class);
			
			System.out.println("타겟은 객체화?: "+id.get());
			
			
			ReflectionEx03 ex=id.get();
			
			System.out.println("멤버필드 스트링값: "+ex.x);
			System.out.println("문자열 리턴타입 메서드: "+ex.show());
	
			
			
		} catch (Exception e) {

			System.out.println("에러..:" + e);
		}

	}

}
