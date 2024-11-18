package com.spring.finall.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.finall.user.UserVO;

@Controller
public class TransactionController {

	@Autowired
	public TransactionEx01 tranex01;	
	
	
	@Autowired
	public TransactionEx02 tranex02;	
	
	
	@RequestMapping(value = "/transactionex01.do")
	public Object transactionex01(TransactionVO tvo) {
		// 지금은 문법 상이므로 직접 VO객체에 set 으로 초기화해주자 웹 연결 아님		
		tvo.setNum(100);
		tranex01.test1(tvo);
		return null;
	}
	

	// 데이터는 모두 동시에 삽입 되거나 동시에 삽입 실패가 되어야 한다.
	//이는 잘못된 처리이다. 원자성 위배.
	@RequestMapping(value = "/transactionex02.do")
	public Object transactionex02(TransactionVO tvo,TransactionVO2 tvo2) {
		// 지금은 문법 상이므로 직접 VO객체에 set 으로 초기화해주자 웹 연결 아님		
		tvo.setNum(100);
		tranex01.test2(tvo,tvo2);
		return null;
	}
	// 데이터는 모두 동시에 삽입 되거나 동시에 삽입 실패가 되어야 한다.
	// 원자성이 지켜진 경우
	@RequestMapping(value = "/transactionex03.do")
	@Transactional
	public Object transactionex03(TransactionVO tvo,TransactionVO2 tvo2) {
		// 지금은 문법 상이므로 직접 VO객체에 set 으로 초기화해주자 웹 연결 아님		
		tvo.setNum(100);
		tranex01.test3(tvo,tvo2);
		return null;
	}
	
	@RequestMapping(value = "/transactionex04.do")
	public Object transactionex04(TransactionVO tvo,TransactionVO2 tvo2) {
		// 지금은 문법 상이므로 직접 VO객체에 set 으로 초기화해주자 웹 연결 아님		
		tvo.setNum(100);
		
		tranex01.test4(tvo,tvo2);
		return null;
	}
	
	//오류를 일으켜 보자.
	@RequestMapping(value = "/transactionex05.do")
	public Object transactionex05(TransactionVO tvo,TransactionVO2 tvo2) {
		// 지금은 문법 상이므로 직접 VO객체에 set 으로 초기화해주자 웹 연결 아님		
		tvo.setNum(400);
		tvo2.setNum(500);
		tranex01.test5(tvo,tvo2);
		return null;
	}

	//동시에 우연의 일치로 같은 아이디로 회원가입을 시켜보자.
		@RequestMapping(value = "/transactionex06.do")
		@ResponseBody
		public Object transactionex06(UserVO uvo) {
			
			uvo.setUser_where("naveruser");
			uvo.setId("sameId");
			uvo.setPassword("1234");
			uvo.setUser_tell("010-91313-0686");
			uvo.setUser_name("똑같은 이름");
			tranex02.test1(uvo);
			return null;
		}

		// 우연의 일치로 동시에 같은 아이디로 가입하는 경우의 문제
		//위와 같은 동시성 문제를 한번 해결하여 보자.
		
				@RequestMapping(value = "/transactionex07.do")
				public Object transactionex07(UserVO uvo) {					
					uvo.setUser_where("naveruser");
					uvo.setId("sameId");
					uvo.setPassword("1234");
					uvo.setUser_tell("010-91313-0686");
					uvo.setUser_name("똑같은 이름");				
					
					try {
						tranex02.test2(uvo);
						System.err.println("가입 성공에 성공하였습니다.");
						return "가입 성공~";
					}catch(Exception e) {
						System.out.println(e);
						System.err.println("그새 동일아이디로 누가 가입했네요 ㅎㅎ 에러임");
						return "그새 동일아이디로 누가 가입했네요 ㅎㅎ 에러임";
					}					
					
					
				}		
				
//				@RequestMapping(value = "/transactionex08.do")
//				public Object transactionex07(UserVO uvo) {					
//					uvo.setUser_where("naveruser");
//					uvo.setId("sameId");
//					uvo.setPassword("1234");
//					uvo.setUser_tell("010-91313-0686");
//					uvo.setUser_name("똑같은 이름");				
//					
//					try {
//						tranex02.test2(uvo);
//						System.err.println("가입 성공에 성공하였습니다.");
//						return "가입 성공~";
//					}catch(Exception e) {
//						System.out.println(e);
//						System.err.println("그새 동일아이디로 누가 가입했네요 ㅎㅎ 에러임");
//						return "그새 동일아이디로 누가 가입했네요 ㅎㅎ 에러임";
//					}					
//					
//					
//				}		
		
		
	

	
}
