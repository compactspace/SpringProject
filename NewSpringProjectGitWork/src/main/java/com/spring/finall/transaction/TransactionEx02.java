package com.spring.finall.transaction;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.finall.user.MemberService;
import com.spring.finall.user.UserVO;

//우선 닥치고
// @Transactional 는 클래스 메소드 인터페이스 등에 붙일 수 있단다.

@Service
public class TransactionEx02 {

	@Autowired
	private SqlSessionTemplate mybatis;

	
	@Autowired
	private MemberService memberService;
	
	//동시에 우연으로 같은 아이디로 회원 가입을 한다면??
	
	public void test1(UserVO uvo) {		
		
		int executerows=mybatis.insert("UserVO.insertmember", uvo);
		System.out.println("데이터 삽입 성공시 행수는? ->>" + executerows);

	}

	//트랜잭션 흠.. 우선 Isolation.SERIALIZABLE 만 먹힘 나머지는 동일 가입 처리가 되어버림
//	@Transactional(isolation = Isolation.SERIALIZABLE)
//	@Transactional(isolation = Isolation.REPEATABLE_READ)
//	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	//@Transactional(isolation = Isolation.READ_COMMITTED)// 또 지랄병걸림 서버 껏다가 킨뒤 하면 또 안먹히고 한번 DB를 지운뒤에 해야 먹힘 장난??
														//하 이유를 모르겠네
//	@Transactional(isolation = Isolation.SERIALIZABLE)	
//	@Transactional(isolation = Isolation.READ_COMMITTED)
//	@Transactional
	public void test2(UserVO uvo) {			
		Integer checkcount=(Integer) mybatis.selectOne("UserVO.isDuplicated",uvo);
		System.err.println("checkcount->>>"+checkcount);
		if(checkcount>=1) {			
			throw new RuntimeException("동일한 아이디 가입임!!");
		}else {
			int executerows=mybatis.insert("UserVO.insertmember", uvo);				
		}
		

	}

}
