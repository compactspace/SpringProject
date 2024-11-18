package com.spring.finall.grammar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderEx01 {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\InputStreamTest.txt");

		String path = f.getPath();
		System.out.println("파일경로: " + path);
		// 이젠 입력 스트림을 문자열로 받아보자.
		
		InputStream ins = new FileInputStream(path);
		//바이트 -> 차 -> 문자열로 확장될수록 생성자인수 패턴도 동일함을 알수있다.
		BufferedReader buffer= new BufferedReader(new InputStreamReader(ins));
		
String data=buffer.readLine();

System.out.println("리드라인 데타: "+data);
		
	}

}
