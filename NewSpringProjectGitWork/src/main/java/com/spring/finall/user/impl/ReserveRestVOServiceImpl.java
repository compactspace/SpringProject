package com.spring.finall.user.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.finall.user.ReserveRestVOService;

@Service(" ReserveRestVOService")
public class ReserveRestVOServiceImpl implements  ReserveRestVOService {

	@Autowired
public ReserveRestDAOMybatis mybatis;
	
	@Override
	public Integer restOneDayClass(HttpServletRequest req) {
		return mybatis.restOneDayClass(req);
		
	}

	@Override
	public void reserverestupdate(HttpServletRequest req) {
		mybatis.reserverestupdate(req);
		
	}

	@Override
	public void reserverestpaycancelupdate(HttpServletRequest req) {
		
		mybatis.reserverestpaycancelupdate(req);
		
	};
	
	
}
