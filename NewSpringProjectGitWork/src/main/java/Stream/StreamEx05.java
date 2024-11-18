package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.emory.mathcs.backport.java.util.Arrays;

public class StreamEx05 {
	
	public static void main(String[] args) {
		
		String [] strarr= {"a","a","Aa","ba","aa","ba"};
		
		//distinct()
		//기존 스트림의 중복된 요소를 제거한뒤 새로운 스트림을 반환합니다.
		
		Stream<String> stream=Arrays.asList(strarr).stream();
		
		Stream<String> newstream=stream.distinct();
		
		List<String> list=newstream.collect(Collectors.toList());
		System.out.println(list);
		
		
		
		
		
	}

}
