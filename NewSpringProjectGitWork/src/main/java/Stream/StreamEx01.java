package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx01 {

	
	
	public static void main(String[] args) {
		
		String[] strarr= {"A","B"};
		
		//Arrays.asList : 배열을 리스트화 한다. 단 리스트의 add crearl는 구현이 되지 않아 에러뜽ㅁ.
		
		List<String> list=Arrays.asList(strarr);
		
		//스트림 객체 생성 Stream<T> stream=컬렉션객체명.stream()
		Stream<String> stream=list.stream();
		
		
		//일반 배열로 스트림 생성하기
		String[] strarr2= {"A","B","C","D"};
		Stream<String> streamArray=Arrays.stream(strarr2);
		

	}

}
