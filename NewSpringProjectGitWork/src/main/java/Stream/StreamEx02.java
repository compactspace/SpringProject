package Stream;

import java.util.List;
import java.util.stream.Stream;

import edu.emory.mathcs.backport.java.util.Arrays;

public class StreamEx02 {

	public static void main(String[] args) {
		
		String[] strarr= {"apple", "banana", "cherry", "durian"};
		List<String> list=Arrays.asList(strarr);
		
		Stream<String> stream=list.stream();
		
		//스트림은 애초에 저장되어있는 데이터를 조회 가공하는 것이라했는데 이제 해보자
		
		stream.filter(null);

	}

}
