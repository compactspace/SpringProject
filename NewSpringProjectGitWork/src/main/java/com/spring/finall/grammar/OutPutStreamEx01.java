package com.spring.finall.grammar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamEx01 {

	public static void main(String[] args) throws IOException {

		// 이번엔 실제 파일로 스트림을 출력한다 외부로!! 로컬디스크에 있는 InputStreamTest.txt 을 보라
		FileOutputStream outputStream = new FileOutputStream("C:\\InputStreamTest.txt");

		byte[] bytes = "고구마, 수박맛 맛동산고구마".getBytes();
		for (byte b : bytes) {
			outputStream.write(b);
		}

		System.out.println("ㅇㅇ 프로그램 종료 ㅇㅇ");

	}

}
