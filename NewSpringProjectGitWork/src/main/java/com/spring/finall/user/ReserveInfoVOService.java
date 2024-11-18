package com.spring.finall.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ReserveInfoVOService {

	public abstract boolean insertreserveinfo(ReserveInfoVO vo);
	
	public abstract boolean checkreserveinfo(ReserveInfoVO vo);
	
	public abstract List<Object>  myreserveinfo(HttpServletRequest req);
	//public abstract UserVO login(UserVO vo);
	
	public abstract void paystatusupdate(HttpServletRequest req);
	
}
