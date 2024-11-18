package com.spring.finall.grammar2;

public class ArrayEx01 {

	public static void main(String[] args) {
		
		// 이런식으로 초기화시 공한 할당 까지 해야한다.
		int[] intarray= new int[4];
		
	//우선 귀차나서 반복문으로 값을 초기화하자.	
	for(int k=0; k<intarray.length; k++) {
		intarray[k]=k;		
	}
	
	//배열의 요소 가져오기
	System.out.println("0번방요소: "+intarray[0]);
	
	//요소 가져오기는 O(1)란다.
	//대략적으로 다음처럼 계산이 되어있는듯하다.
	//intarray[2]=intarray[0+2], intarray[1]=intarray[0+1]
	// 이렇게 단순 합의 연산으로 대충 진짜 이정도만 생각
		
		
	}

}
