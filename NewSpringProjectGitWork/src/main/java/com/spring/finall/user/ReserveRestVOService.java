package com.spring.finall.user;

import javax.servlet.http.HttpServletRequest;

public interface ReserveRestVOService {
	
	
	public abstract Integer restOneDayClass(HttpServletRequest req);
	
	
	//이는 결제 성공후 자리수 감소 업데이트임
	public abstract void reserverestupdate(HttpServletRequest req);
	
	
	//이는 결제 취소 성공후 자리수 하나 올려주는 업데이트임
	public abstract void reserverestpaycancelupdate(HttpServletRequest req);
	
	

}
