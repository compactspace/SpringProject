package FunctionalInterface;


public interface FunctionalInterface<T> {
	
	// abstract method 오직 하나만 있어야함
	T pickMeUp();
	
	//디펄트는 여러개 ok!!!
	
	default FunctionalInterface<T> show1() {
		return ()->pickMeUp();
	}
	
	default String show2() {
		return "안녕못하냐";
	}

}
