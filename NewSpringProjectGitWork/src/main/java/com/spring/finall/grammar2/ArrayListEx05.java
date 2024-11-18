package com.spring.finall.grammar2;

public class ArrayListEx05 {

	public static void main(String[] args) {
//		String str ="551050";
//		 str.matches("[05]+");
//		 System.out.println(str.matches("[05]+"));
		 
		 for (int i = 1; i < 64; i++) {
	            int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
	            
	            System.out.println(num);
	            
	        }

	}

}
