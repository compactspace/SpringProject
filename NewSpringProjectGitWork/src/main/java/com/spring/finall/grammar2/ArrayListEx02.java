package com.spring.finall.grammar2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListEx02 {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(1, 1, 2, 3, 4, 5);

		int size = 0;
		int index = 0;
		while (size < numList.size()) {

			System.out.println("numList[\"index\"]" + numList.get(index));
			index++;
			size++;

		}

		List<Integer> newList = numList.stream().distinct().collect(Collectors.toList());

		System.out.println("-------------리스트에서 중복 제거후------");

		size = 0;
		index = 0;
		while (size < newList.size()) {

			System.out.println("numList[\"index\"]" + newList.get(index));
			index++;
			size++;

		}

		System.out.println("--------------------------------------------------------------------");
		List<String> list = new ArrayList(Arrays.asList("A", "B", "B","B" ,"C", "D", "D"));

		List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
		for (int k = 0; k < distinctList.size(); k++) {
			System.out.println(distinctList.get(k));
		}

	
	

	}

}
