package com.spring.finall.user.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.finall.user.ReserveInfoVO;
import com.spring.finall.user.ReserveInfoVOService;

@Service("ReserveInfoVOService")
public class ReserveInfoVOServiceImpl implements ReserveInfoVOService {

	@Autowired
	public ReserveInfoDAOMybatis rdao;

	@Override
	public boolean insertreserveinfo(ReserveInfoVO vo) {

		return rdao.insertreserveinfo(vo);
	}

	@Override
	public boolean checkreserveinfo(ReserveInfoVO vo) {

		return rdao.inscheckreserveinfo(vo);

	};

	@Override
	public List<Object> myreserveinfo(HttpServletRequest req) {

		return rdao.myreserveinfo(req);
	}
	
	@Override
	public void paystatusupdate(HttpServletRequest req){
		
		rdao.paystatusupdate(req);
		
	};
	
	

}
