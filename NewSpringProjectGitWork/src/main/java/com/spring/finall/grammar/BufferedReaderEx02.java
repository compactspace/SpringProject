package com.spring.finall.grammar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderEx02 {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\InputStreamTest.txt");

		String path = f.getPath();
		System.out.println("파일경로: " + path);
		// 이젠 입력 스트림을 문자열로 받아보자.

		InputStream ins = new FileInputStream(path);
		// 바이트 -> 차 -> 문자열로 확장될수록 생성자인수 패턴도 동일함을 알수있다.
		BufferedReader buffer = new BufferedReader(new InputStreamReader(ins));

		
		
		//변할수있는 스트링값 객체를 제공한다. 우선 이정도만 알고있자.
		// 즉 일반 자료형은 변수명이 값을 가지고있는데
		//문자열을 객체라 값이 변하면 객체주소가 변하여 새로운 객체가 탄생한다.
		StringBuilder stringbuilder = new StringBuilder();
		
		// 즉 일반 자료형은 변수명이 값을 가지고있는데
				//문자열을 객체라 값이 변하면 객체주소가 변하여 새로운 객체가 탄생한다.
		String juststring = "x";
		System.out.println(System.identityHashCode(juststring));
		juststring=juststring+"고구마";
		System.out.println(System.identityHashCode(juststring));
		
		
		while(true) {
			String data;
			if((data=buffer.readLine())!=null) {
				stringbuilder.append(data);
			System.out.println(stringbuilder);
			//객체 주소가 동일함을 주목하자.
				System.out.println(System.identityHashCode(stringbuilder));
			}
			
		}
		
		

	}

}
