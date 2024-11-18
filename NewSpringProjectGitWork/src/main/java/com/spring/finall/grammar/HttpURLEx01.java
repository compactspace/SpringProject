package com.spring.finall.grammar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpURLEx01 {

	public static void main(String[] args) throws IOException {

		URL url = new URL("https://jsonplaceholder.typicode.com/comments");
		// 출력결과 :https://jsonplaceholder.typicode.com/comments
		System.out.println("url: " + url);
		// 출력겨롸 : //jsonplaceholder.typicode.com/comments ->https: 만 빠져있다.
		System.out.println("url.toExternalForm" + url.toExternalForm());

		// HTTP Connection 구하기 (초창기 쌩자바 db컨넥션이라 생각하자 쉽게 쉽게)
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 출력결과 :
		// sun.net.www.protocol.https.DelegateHttpsURLConnection:https://jsonplaceholder.typicode.com/comments
		System.out.println("conn: " + conn);

		// get 인지 post인지 세팅한다.
		conn.setRequestMethod("GET");

		// 계속 연결되어 있으면 곤란하니 연결시간과 데이터를 받아오는 시간을 세팅하도록하자.

		conn.setConnectTimeout(3000);
		conn.setReadTimeout(3000);

		// 요청 방식 구하기
		System.out.println("getRequestMethod():" + conn.getRequestMethod());
		// 응답 콘텐츠 유형 구하기
		System.out.println("getContentType():" + conn.getContentType());
		// 응답 코드 구하기
		System.out.println("getResponseCode():" + conn.getResponseCode());
		// 응답 메시지 구하기
		System.out.println("getResponseMessage():" + conn.getResponseMessage());

		// 응답 헤더의 정보를 모두 출력
		for (Map.Entry<String, List<String>> header : conn.getHeaderFields().entrySet()) {
			for (String value : header.getValue()) {
				System.out.println(header.getKey() + " : " + value);
			}
		}

		// 응답 내용(BODY) 구하기
		try (InputStream in = conn.getInputStream(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			byte[] buf = new byte[1024 * 8];
			int length = 0;
			
			//ㅇㅇ스트림을 와일문에서 열고있다 리드 펑션으로 
			while ((length = in.read(buf)) != -1) {
				// 스트림이 열린뒤니 이제 출력스트림으로 buf에 담긴걸 해주면된다.
				out.write(buf, 0, length);
			}
			
			//여기서 출력한다.
			System.out.println(new String(out.toByteArray(), "UTF-8"));
		}

		// 접속 해제
		conn.disconnect();

	}

}
