package com.spring.finall.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.finall.user.ReserveService;
import com.spring.finall.user.ReserveVO;
import com.spring.finall.user.UserVO;

@Service("reserveservice")
public class ReserveServiceImple implements ReserveService {
	
	@Autowired
	private ReserveDAOMybatis reserveDAO;
	
	
	
	

	@Override
	public boolean insertreserve(ReserveVO vo ,String checks) {
		
		boolean checkreserve= reserveDAO.insertreserve(vo ,checks);
		if(checkreserve==true) {
			return true;
		}else {
			return false;
		}
		
	}


	@Override
	public UserVO login(UserVO vo) {
		return	reserveDAO.getuser(vo);
	
		// TODO Auto-generated method stub
		
	}




}
