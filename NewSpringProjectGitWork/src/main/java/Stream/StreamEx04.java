package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.emory.mathcs.backport.java.util.Arrays;

public class StreamEx04 {

	public static void main(String[] args) {
	
		//스트림 생성을 을 알아보았으니 여러가지 가공법을 알라보자.
		
		//of 함수 역시 스트림 생성 기법이다.
		Stream<String> stream = Stream.of("apple", "banana", "cherry");
		
		//map(Function<? super T, ? extends R> mapper)
		//기존 스트림의 각 요소에 대해 매핑 함수를 적용하여 새로운 Stream을 반환
		Stream<Integer> othersteam=stream.map((x)->x.length());
		
		List<Integer> newlist= othersteam.collect(Collectors.toList());
		
		System.out.println(newlist);
		
		//sorted()
		//요소를 정렬하여 Stream으로 반환합니다.
		String[] strarr= {"A","a","b","B","c","D"};
		
		List<String> list=Arrays.asList(strarr);
		
		Stream<String> sstream=list.stream();
		
		List<String> new_list=sstream.sorted().collect(Collectors.toList());
		
		System.out.println(new_list);
		
		
		
		
		
		

	}

}
