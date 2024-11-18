package com.spring.finall.grammar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLEx02 {

	public static void main(String[] args) throws IOException {
//		URL url = new URL("https://jsonplaceholder.typicode.com/comments");
//		// 출력결과 :https://jsonplaceholder.typicode.com/comments
//		System.out.println("url: " + url);
//		// 출력겨롸 : //jsonplaceholder.typicode.com/comments ->https: 만 빠져있다.
//		System.out.println("url.toExternalForm" + url.toExternalForm());
//
//		// HTTP Connection 구하기 (초창기 쌩자바 db컨넥션이라 생각하자 쉽게 쉽게)
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		
//		InputStream datafromserver=conn.getInputStream();
//		
//		
//		while(true) {
//			if(datafromserver.read()==1) {break;}
//			System.out.println("받은 data: "+(char)datafromserver.read());
//			
//		}
//		datafromserver.close();
		
		URL url2 = new URL("https://jsonplaceholder.typicode.com/comments");
		// 출력결과 :https://jsonplaceholder.typicode.com/comments
		System.out.println("url: " + url2);
		// 출력겨롸 : //jsonplaceholder.typicode.com/comments ->https: 만 빠져있다.
		System.out.println("url.toExternalForm" + url2.toExternalForm());

		// HTTP Connection 구하기 (초창기 쌩자바 db컨넥션이라 생각하자 쉽게 쉽게)
		HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
		
		
		InputStream ins=conn2.getInputStream();
		
		InputStreamReader insr=new InputStreamReader(ins);
		
		BufferedReader buffer=new BufferedReader(insr);		
		
		System.out.println("---------------서버로부터 받은 data---------------------");
//		System.out.println(buffer.readLine());
		
		while(true) {
			//바이트와 다르게 널임을 상기한다.
			if(buffer.readLine()==null) {break;}
			System.out.println("서버로부터 데이터: "+buffer.readLine());			
		}
// 한편 bite 이던 char 이던 미리 스트림을 담을 공간배열 byte[] char[] 를 생성했었는데 String는 어떻게할까??
		//스트링 빌더로 간다. BufferedReaderEx02 와 HttpURLEx02 참조 
		
		
	}

}
