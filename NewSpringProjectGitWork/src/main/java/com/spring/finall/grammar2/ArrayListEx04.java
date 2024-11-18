package com.spring.finall.grammar2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListEx04 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 1, 2, 7));
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		Collections.sort(list);
		int check=0;
		
		for (int k = 0; k < list.size(); k++) {
			
			int count = Collections.frequency(list, list.get(k));
			System.out.println("count==1?:    "+(count==1));
			if(count==1) {
				
				
				list3.add(list.get(k));
			}
			
			if(count>=2) {
				list2.add(list.get(k));
			}
			
		
		}
		List<Integer> newList2 = list2.stream().distinct().collect(Collectors.toList());
		List<Integer> newList3 = list3.stream().distinct().collect(Collectors.toList());

		for (int k = 0; k < newList2.size(); k++) {
			System.out.println("newList2:   "+newList2.get(k));
			
		}
		
		
		for (int k = 0; k < newList3.size(); k++) {
			System.out.println("newList3:   "+newList3.get(k));
			
		}
		
		newList3.toArray(new Integer[4]);
	}

}
