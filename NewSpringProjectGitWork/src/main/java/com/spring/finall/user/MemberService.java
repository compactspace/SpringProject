package com.spring.finall.user;

import java.util.List;

public interface MemberService {

	public abstract void insertMembership(UserVO vo);
	
	public abstract Integer selectusercode(UserVO vo);
	
	public abstract Integer selectmainhomeuser_code(UserVO vo);
	

	public abstract boolean checkidMembership(UserVO vo);

	public abstract String loginpasswordMembership(UserVO vo);

	public abstract boolean checkidMembershiptwo(UserVO vo);

	public abstract int changepasswordcomplete(UserVO vo);

	public abstract void insertPhone(UserVO vo);
	
	public abstract boolean checkPhoneMembership(UserVO vo);
	
	
	public abstract List<Object> mypersonalinfo(UserVO uvo);
	
	
	//sql 인젝션 로그인 테스트
	public abstract List<UserVO> injectionLogin(UserVO vo);
}
