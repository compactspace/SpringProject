package com.spring.finall.grammar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpMainEx02 {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
	//외부 아이피 들은 거즌 다래와 같은 json형식으로 데이터를 준다.		
	String json="{\"key1\":\"stringvalue\"}";
	System.out.println(json);
	
	
	//따라서 우리는 저 받은걸 자바가 알아먹을 수 있게 변환해주어야한ㄷ.
	ObjectMapper mapper = new ObjectMapper();
	
	
	//리드트리는 그냥 json나무를 읽는다 생각
	 JsonNode rootNode = mapper.readTree(json);
	 
	 System.out.println(rootNode);
	 
	 
	 System.out.println("------------------구분선--------------------------");
	 
	 
	 String json2="{\"key1\":\"stringvalue\",\"key2\":{\"key1\":\"stringvalue\"}}";
	 
JsonNode rootNode2 = mapper.readTree(json2);
	 
	 System.out.println(rootNode2);
	 
		String INFOHEADER = mapper.writeValueAsString(rootNode2);
		System.out.println("INFOHEADER->>>>" + INFOHEADER);
	 
		// 키콜.벨류로 자바스크립트에서 가져왔듣 여기선 get(키명)으로 받자.
		JsonNode resNodekey2 = rootNode2.get("key2");
		
		String INFO = mapper.writeValueAsString(resNodekey2);
		System.out.println("INFOHEADER->>>>" + INFO);
		
		// 중첩 json형식이면 또한번 빼오면 된다
		JsonNode resNodekey3 =resNodekey2.get("key1");
		System.out.println("key1->>>>" + mapper.writeValueAsString(resNodekey3));
		
		
	}

}
