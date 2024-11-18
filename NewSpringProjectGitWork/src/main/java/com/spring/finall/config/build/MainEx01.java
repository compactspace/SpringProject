package com.spring.finall.config.build;

import com.spring.finall.config.build.User2.ResUserDTO;

public class MainEx01 {

	public static void main(String args[]) {		
	
		 //자바 코드로만
		 User user = new User.UserBuilder("김개똥").Builer();
		 System.out.println(user);

		
		//자바 코드로만
		 User2 user2 = User2.builder().sex("남자").build(); 
		 System.out.println(user2.sex);
//		 
		 //람복을 이용한 빌더패턴
		 //주의해라 builder() 는 람복이 만들어 준것이다.
		 //하지만 우리가 자바코드로만 구현 했던 것처럼 리턴값은 ReqUserDTO 이다.
		 //마찬가지로 build() 도 람복이 제공해 준건이다.
		 User2 user3 = User2.builder().age(1).build();
		 
		 
		 
		 System.out.println(user3.getAge());
		 
		 String id="dsdfXQLSsdfsdf";
		 
		 String replace=id.replace("XQLS", "");
		 System.out.println("문자열제거->>"+replace);
		 System.out.println("dsdfsdfsdf".equals(replace));
	
	
		 
	}

}
