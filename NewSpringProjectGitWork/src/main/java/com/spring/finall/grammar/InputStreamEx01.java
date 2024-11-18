package com.spring.finall.grammar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx01 {
	
	public static void main(String[] args ) throws IOException {
		File f = new File("C:\\InputStreamTest.txt");
		
		
		String path= f.getPath();
		System.out.println("파일경로: "+path);		
		InputStream ins=  new FileInputStream(path);	
		
		// read() 스트림을 받아드린다 시작한다 이고
		// 리턴값은 0~255(또는 256) 사이의 정수형인 아스키 코드를 반환 한다.	
		// 실제로 char로 다운 캐스팅 하면 그에 해당하는 문자열이 나온다.
		// 아갈무새들 4바이트이고 마지막칸에 1바이트 저장된다는 소리는 우선 무시
//		int readss = ins.read();
//	    System.out.println("readss: "+readss);
//		
//		while(true) {
//			int reads = ins.read();
//			if(reads!=-1) {
//				System.out.println("reads: "+reads);
//				System.out.println("(char)reads: "+(char)reads);
//			}else {
//				break;
//			}
//			
//		}	
		
		
		
		//System.out.println("스트림: "+ins);
		//바이트(Byte)  1 바이트 = 8 비트
		//bit         1 비트  = 1/8 바이트 
		byte[] arr = new byte[10];
		System.out.println("스트림이 읽기전");
		for(int k=0; k<arr.length; k++) {
			System.out.println("arr[k]: "+arr[k]);
		}
		
		
		
		// read(byte[]) 꼴 : 지정한 바이트만 받고 읽은뒤 정수형 자료형인 4바이트로 0~255사이의 아스키 코드를 리턴한다.
		// 미리 인풋스트림이 받을 바이트를 지정한다. 가령 위 바이트 배열을 10으로 줄인하면 실제로 hello, wor 까지만 출력된다.
		int read = ins.read(arr);		
		System.out.println("read = " + read);
		
		
		//스트림이 열린후 뭐가있을까?
		System.out.println("스트림이 읽은후");
		for(int k=0; k<arr.length; k++) {
			System.out.println("arr[k]: "+arr[k]);
		}
		
		
		// 개념은 어렵지만 스트림이 열린후 바이트 배열을 스트링화 하면 받은 아스키코드가 실제로 문자열화된다.
		String str = new String(arr);
		System.out.println("str = " + str); // hello, world! 또는 사이즈 줄임에 따라  hello, wor 가 출력됨
		
		ins.close();
		// Stream은 사용이 끝난 이후 닫아 자원을 해제해야한다.
	}

}
