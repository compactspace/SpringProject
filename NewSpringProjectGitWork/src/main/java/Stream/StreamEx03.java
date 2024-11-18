package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.emory.mathcs.backport.java.util.Arrays;

public class StreamEx03 {

	public static void main(String[] args) {
		
		
		Integer[] arr= {1,2,3,4,5,6,7,8};
		
		List<Integer> list =Arrays.asList(arr);
		
		//컬랙션 객체로 스트림을 만든다.
		Stream<Integer> stream=list.stream();
		
		//이제 Stream 이 제공하는 filter 메서드의 매개변수 꼴을 보자.
		//Stream<T> filter(Predicate<? super T> predicate)
		
		//여기서 filter 메서드는 기능 위주로만 본다 아직 내 해석 수준은 아니다.(추상메서드이고 난 구현한적이 없는데 호출이됨..)
		//또한 매개변수도 predicate 으로 객체던 뭐던 해야 하는데 아무튼 어려운 기법이니 기능 위주로본다.
		
		//하지막 이건 확실하다. 기존 스트림의 데이터를 가공한뒤 filter실행후 새로운 stream을 리턴한다.
		Stream<Integer> newstream=stream.filter(n->n%2==0);
		
		System.out.println("기존 스트림:  "+stream);
		System.out.println("--------------------------------------------------------------");
		System.out.println("필터이후 새로운 스트림:  "+stream);
		//분명히 주소갑이 다르자.
		
		//이제 가공된 스트림을 다시 리스트로 변형시킨다.
		//collect(Collectors.toList()) 스트림을 다시 컬랙션 list로 변형시킨다.
		List<Integer> newlist=newstream.collect(Collectors.toList());
		for(Integer x : newlist) {
			System.out.println(x);
		}
		
		
		
		
	}

}
