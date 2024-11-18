package com.spring.finall.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.finall.user.MemberService;
import com.spring.finall.user.UserVO;

@Service("memberserviceimpl")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAOMybatis mdao;

	@Override
	public void insertMembership(UserVO vo) {
		mdao.insertMembership(vo);

	}

	@Override
	public Integer selectusercode(UserVO vo) {

		return mdao.selectusercode(vo);

	};
	@Override
	public  Integer selectmainhomeuser_code(UserVO vo) {
		
		return mdao.selectmainhomeuser_code(vo);
	}
	

	@Override
	public boolean checkidMembership(UserVO vo) {
		boolean check = mdao.checkidMembership(vo);

		return check;

	}

	@Override
	public boolean checkidMembershiptwo(UserVO vo) {
		boolean check = mdao.checkidMembershiptwo(vo);

		System.out.println("마이베티스 트루문이면 check는 트루여야함" + check);
		return check;

	}

	@Override
	public String loginpasswordMembership(UserVO vo) {
		List<UserVO> luvo = mdao.loginpasswordMembership(vo);
		UserVO uvo = luvo.get(0);
		uvo.getPassword();
		System.out.println("각자마다 암호회된 비번이 달라야한다." + uvo.getPassword());
		return uvo.getPassword();

	}

	@Override
	public int changepasswordcomplete(UserVO vo) {
		int check = mdao.changepasswordcomplete(vo);
		System.out.println("업데이트 check 뭘받으려나" + check);

		return check;

	}

	// 핸드폰가입자용
	@Override
	public void insertPhone(UserVO vo) {

		mdao.insertMembership(vo);
	}

	@Override
	public boolean checkPhoneMembership(UserVO vo) {
		boolean check = mdao.checkPhoneMembership(vo);

		System.out.println("check가 트루이면->" + check + "-> 새로운가입자로 가입시키고 로그인시키면되고" + " ,펠스이면 기가입자로 바로 로그인시키고");
		return check;

	}
	@Override
	public List<Object> mypersonalinfo(UserVO uvo){
		
		return mdao.mypersonalinfo(uvo);
	}
	
	
	
	//sql 인젝션 로그인 테스트
	public List<UserVO> injectionLogin(UserVO vo) {
		
		return  mdao.injectionLogin(vo);
		
	}
	
	
	

}
