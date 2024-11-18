package com.spring.finall.grammar2;

import java.util.*;

public class ArrayListEx03 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Arrays.asList("A", "B", "C", "A"));
		int count = Collections.frequency(list, "A");
		System.out.println(count);

	}

}
