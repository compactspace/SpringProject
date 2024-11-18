package com.spring.finall.javasyntax;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


//Java Object → JSON 형태로 파일 만들기 그리고 스트링으로 받아 출력해보기 예제
public class ObjectMapperEx {
	
	// 단 사전 조건으로 다음 라이브러리가 설치되어있어야한다.
//	<!--아작스 -->
//	<dependency>
//		<groupId>com.fasterxml.jackson.core</groupId>
//		<artifactId>jackson-databind</artifactId>
//		<version>2.12.6</version>
//	</dependency>
//	
	
	public static void main(String[] args) {
		
		//또 사전 조건
//		위와 같이 파라미터로 JSON을 저장할 파일과 직렬화시킬 객체를 넣어주면 된다.
//
//		여기서 주의할 점은 JSON으로 직렬화 시킬 클래스에 Getter가 존재해야 한다는 것이다.
//
//		Jackson 라이브러리는 Getter와 Setter를 이용하여 prefix를 잘라내고 맨 앞을 소문자로 만드는 것으로 필드를 식별한다		
		
		
	    ObjectMapper objectMapper = new ObjectMapper();
		// Java Object ->  JSON 
	    TestVO vo = new TestVO(1,"남자.");
	      
	    // 각각파일로 만들기 스트링으로 출력하기를 해보자.
	        try {
	        	// 다행이 File src 경로는 내 프로젝트 src 경로로 인식해준다.
	            objectMapper.writeValue(new File("src/TestVO.json"), vo);
	       
	            String userAsString = objectMapper.writeValueAsString(vo);
	        
	            System.err.println(userAsString);
	            
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
