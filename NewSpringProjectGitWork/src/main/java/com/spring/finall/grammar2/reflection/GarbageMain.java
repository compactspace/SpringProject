package com.spring.finall.grammar2.reflection;

public class GarbageMain {

	public static void main(String[] args) {

		int left = 1;
		int right = 10;
		int mid=0;
		System.out.println(left < right);
		
		while (left < right) {

			System.out.println("left값: "+left);
			
			mid=(right+left)/2;
			if(mid>4) {
				System.out.println("left값: "+left);
				left=9;
				
			}
			

		}
	}

}
