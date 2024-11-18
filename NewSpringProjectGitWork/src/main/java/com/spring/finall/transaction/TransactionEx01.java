package com.spring.finall.transaction;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

//우선 닥치고
// @Transactional 는 클래스 메소드 인터페이스 등에 붙일 수 있단다.

@Service
public class TransactionEx01 {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public void test1(TransactionVO tvo) {
		boolean txActive1 = TransactionSynchronizationManager.isActualTransactionActive();
		boolean txActive2 = TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println("프록시?->>>>>" + txActive1);
		System.out.println("프록시?->>>>>" + txActive2);

		System.out.println("트랜젝션 테스트메소드1 tvo.getNum()->>" + tvo.getNum());
		int check = mybatis.insert("TransactionVO.inserttransaction", tvo);

		System.out.println("데이터 삽입 성공시 행수는? ->>" + check);

	}

	// 다음은 데이터베이스 일부로 오류임 데이터는 동시에 들어가거나 동시에 모두 실패햐 한다.
	// 그러나 다음 예제는 transaction 에는 데이터가 들어가고 transaction2 는 에러로 않된다!
	// 무조건 동시에 삽입되거나 동시에 에러가 되야한다.
	// 그러나 test3 메소드에 @Transactional 을 붙여 보자.
	public void test2(TransactionVO tvo, TransactionVO2 tvo2) {
		
		int check = mybatis.insert("TransactionVO.inserttransaction", tvo);
		//일부러 말도 않되는 에러를 일으키려고 변수를 그냥 스트링 처리함
		int check2 = mybatis.insert("TransactionVO.inserttransaction2", "tvo");

	}

	// @Transactional 이 붙으면
	// 우선 동시에 삽입되거나 어느 쿼리문이 에러가 난다면 나동 롤백을 해주게 된다.!
	
	public void test3(TransactionVO tvo, TransactionVO2 tvo2) {
		System.out.println("일부로 오류를 일으켜 보자." + tvo.getNum());
		int check = mybatis.insert("TransactionVO.inserttransaction", tvo);
		//일부러 말도 않되는 에러를 일으키려고 변수를 그냥 스트링 처리함
		int check2 = mybatis.insert("TransactionVO.inserttransaction2", "tvo");

	}

	// 제이미터로 2개의 요청을 보낸다면 세션도 2개일것이다.
	// 둘중 하나가 우선순위를 갖고, 데이터 조회중 업데이트 인설트가 이상하더라도 되긴된다.
	// 그러나 test5를 봐보자.
	public void test4(TransactionVO tvo, TransactionVO2 tvo2) {
		System.out.println("일부로 오류를 일으켜 보자." + tvo.getNum());
		List<TransactionVO> list = mybatis.selectList("TransactionVO.selectalltransaction");
		for (int x = 0; x < list.size(); x++) {
			System.out.println(list.get(x).getNum());
		}
		int check = mybatis.insert("TransactionVO.inserttransaction", tvo);
		mybatis.update("TransactionVO.updatetransaction", tvo);

		int check2 = mybatis.insert("TransactionVO.inserttransaction2", tvo2);
	}

	// @Transactional(readOnly = true) 는 어떠한 세션이 조회를 하고 있으면
	// 그 조회테이블에 대하여는  업데이트 딜리트를 하지말라는 기능이다.
	// 물론 테이블 자체가 다르면 상관이 없고.
	//즉 int check2 = mybatis.insert("TransactionVO.inserttransaction2", tvo2); 는 지금 상관이없음
	@Transactional(readOnly = true)
	public void test5(TransactionVO tvo, TransactionVO2 tvo2) {
		System.out.println("일부로 오류를 일으켜 보자." + tvo.getNum());
		List<TransactionVO> list = mybatis.selectList("TransactionVO.selectalltransaction");
		for (int x = 0; x < list.size(); x++) {
			System.out.println(list.get(x).getNum());
		}
		int check = mybatis.insert("TransactionVO.inserttransaction", tvo);
		mybatis.update("TransactionVO.updatetransaction", tvo);
//		int check2 = mybatis.insert("TransactionVO.inserttransaction2", tvo2);
	}

}
