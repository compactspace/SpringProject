package com.spring.finall.grammar2;

import edu.emory.mathcs.backport.java.util.Arrays;

public class ArrayEx02 {

	
	//이름조심!! Arrays라는 클래스가 또있다. 메서드들이 직관적인데 몇개를 보자.
	public static void main(String[] args) {
		
		int[] intarr=new int[2];
		int[] intarr2=new int[3];
		for(int k=0; k<intarr.length; k++) {
			
			intarr[k]=k;
			intarr2[k]=k;
		}
		intarr2[2]=3;
		// 주소값이 아니라, 해당배열의 값들이 서로 같은지 물어본다. 현재는 투루이다.
		Arrays.equals(intarr, intarr2);
		System.out.println("값이같니?: "+Arrays.equals(intarr, intarr2));
		
		
		// Arrays.copyOf(복사할배열,사이즈);
		
		
		
		

	}

}
