package com.spring.finall.grammar;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpMainEx01 {

	public static void main(String[] args) {
		//외부 연결 객체 만들기
		//import org.apache.http.client.HttpClient; 을 임폴트
		HttpClient client = HttpClientBuilder.create().build();
		
		//이제 post로 요청할래? get으로 요청할래임 먼저 get
		// 그리고 json제공 사이트 uri임 post 요청을 하면 데이터가 이상하게 오니 json응답 사이트는 반드시
		//get 방식으로!!
		HttpGet post = new HttpGet("https://jsonplaceholder.typicode.com/comments");
		
		
		//이제 요청을 실행하고 받는다.
		try {
			//예제엔 없지만 post.setEntity 는 요청 데이터를 세팅하는 것이다.
			HttpResponse res = client.execute(post);
			
			
			
			 System.out.println("System.out.println(res); 값은");
			 System.out.println(res);
			 System.out.println("-----------------System.out.println(res); 값종료 구분선--------------------------------");
		
			 ObjectMapper mapper = new ObjectMapper();

			 
//			 System.out.println("res.getEntity()----시작");
//			 System.out.println(res.getEntity());
//			 System.out.println("res.getEntity()----종료");
			 
			 
			 // 반드시 이렇게 해야 데이터를 제대로 받는다.
				String infoheader = EntityUtils.toString(res.getEntity());

				 System.out.println("infoheader 값은");
				 System.out.println(infoheader);
				 System.out.println("-----------------infoheader 값종료 구분선--------------------------------");
		
				 JsonNode rootNode = mapper.readTree(infoheader);
				 
		
				 System.out.println("rootNode 값은");
				 System.out.println(rootNode);
				 System.out.println("-----------------rootNode 값종료 구분선--------------------------------");
				 
				 String INFOHEADER = mapper.writeValueAsString(rootNode);
					System.out.println("INFOHEADER->>>>" +INFOHEADER);
				 
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		
	}
	
}
