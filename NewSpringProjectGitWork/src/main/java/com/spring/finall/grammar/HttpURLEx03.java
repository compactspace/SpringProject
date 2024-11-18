package com.spring.finall.grammar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLEx03 {

	public static void main(String[] args) throws IOException {

		
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
		
		StringBuilder b= new StringBuilder();
		
		
		while(true) {
			String data;
			if((data=buffer.readLine())==null) {break;}
			b.append(data);
			System.out.println("서버로부터 데이터: "+b);			
		}

		
		
	}

}
