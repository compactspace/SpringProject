package FunctionalInterface;

import java.util.function.Predicate;

public class FunctionalInterfaceMainEx02 {

	public static void main(String[] args) {

	// 자바제공 함수형 인터페이스  Predicate <T>
	// 1. 추상메서드는 단한개의 boolean test(T t); 가 있다.
	// 따라서 함수형 인터페이스로 사용자가 람다식으로 재정의해서 만들면 된다.	
		
		
		//인터페이스 메서드 재정의 및 객체화 애초에 람다식 기법임
		Predicate<String> predicate = (str)->str.equals("안녕하냐");
		
		//객체화 되었으니 재정의한 메서드 활용해보기
	
		System.out.println("안녕하냐:  "+predicate.test("안녕하냐")+ "  안녕못하냐:  "+predicate.test("안녕못하냐"));
		
		

	}

}
