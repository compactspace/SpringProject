package FunctionalInterface;

import java.util.function.Predicate;

public class FunctionalInterfaceMainEx01 {

	public static void main(String[] args) {
		
		
		//함수형인터페이스 만들기 형식
		// 좌변 함수형인터페이스 객체명 = 람다식
		
		FunctionalInterface<String> f=()->"픽미픽미픽미업";
		
		//위에서 인터페이스 객체화밑 재정의를 한번에 했음으로 재정의한 pickMeUp() 을 호출하게된다.
		String s = f.pickMeUp();
		
	
	
		
		
		
		
		
	}

}
