package com.spring.finall.grammar2;

import java.util.ArrayList;

public class ArrayListEx01 {

	public static void main(String[] args) {
		ArrayList<String> arrlist= new ArrayList();
		
		//요소를 마지막인덱스에 추가
		arrlist.add("첫삽입 요소");
		arrlist.add("두번째 요소");
		arrlist.add("마지막에 삽입된 요소");
		System.out.println("출력: "+arrlist);
		
		//요소에 접근
		System.out.println("첫요소:"+arrlist.get(0)+"둘요소:"+arrlist.get(1)+"세요소:"+arrlist.get(2));
		
		//요소를 수정한다.
		arrlist.set(0, "수정된 첫 요소");
		System.out.println("첫요소만 수정후:"+arrlist.get(0));
		
		//요소를 제거한다.
		arrlist.remove(2);
		System.out.println("요소 제거후: "+arrlist);
		
		

	}

}
