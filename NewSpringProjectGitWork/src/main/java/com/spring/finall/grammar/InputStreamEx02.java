package com.spring.finall.grammar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamEx02 {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\InputStreamTest.txt");

		String path = f.getPath();
		System.out.println("파일경로: " + path);
		try {
			InputStream ins = new FileInputStream(path);
			
			//InputStreamReader : 문자 단위로 읽어 들인다. 그냥 InputStream는 바이트단위로 읽어드렸음을 상기하자.
			InputStreamReader insr= new InputStreamReader(ins);
			
			//따라서 문자단위로 char 배열이 필요하다.
			// 그냥 InputStream는 바이트배열로 읽어드렸음을 상기하자.
			char[] array=new char[20];
			insr.read(array);
			
			System.out.println("인풋스트림리더: "+array);
			
			
		} catch (FileNotFoundException e) {

		}
		// 스트림을 바이트단위 -> 문자(char)단위 로 확장했는데 
		//이제 문자열(String) 단위를 해보자! BufferedReaderEx01로
		

	}

}
