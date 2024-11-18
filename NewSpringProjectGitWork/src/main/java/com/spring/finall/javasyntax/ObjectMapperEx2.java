package com.spring.finall.javasyntax;

import java.util.HashMap;

import org.json.JSONObject;

// 라이브러리 제공  JSONObject, JSONArray 클래스를 활용하여 보자.
//JsonObject
//Json객체로 바꿔주거나, Json객체를 새로 만드는 역할을하며
// 주로 바뀔 대상은 String 이 대상이 된다.
public class ObjectMapperEx2 {
	// 사전 조건으로 다음 라이브러리가 설치 되어있어야한다.
//	<!-- jsonobejct 이하 제공 클래스를 사용하기 위한 라이브러리 -->
//	<dependency>
//	    <groupId>org.json</groupId>
//	    <artifactId>json</artifactId>
//	    <version>20230618</version>
//	</dependency>	

	public static void main(String args[]) {

		JSONObject json = new JSONObject();
		json.put("cookie", "쿠키쿠키쿠키");
		json.put("cookie2", "쿠키쿠키쿠키2");
		System.err.println(json);

		// 또한 HashMap 으로 Json을 만들수도 있다.
		HashMap<Object, Object> map = new HashMap();
		map.put("값1", "값1");
		map.put("값1", "값1");
		map.put("값1", "값1");
		map.put("값1", "값1");
		JSONObject json2 = new JSONObject(map);
		System.err.println(json2);
		
		String str = "{\"read\" : true, \"book\" : \"happy\"}";
		System.err.println(str);
	}

}
