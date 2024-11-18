package com.spring.finall.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.finall.WorkImgVO;
import com.spring.finall.service.WorkService;
@Service("workservice")
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkDAOMybatis workDAO;

	@Override
	public void insertworkimg(WorkImgVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<WorkImgVO> gettworkimg(WorkImgVO vo) {
		
		return workDAO.getworkList(vo);

	}
	
	
	@Override
	public List<WorkImgVO> graterthanonepage(WorkImgVO vo) {
		
		return workDAO.graterthanonepage(vo);

	}
	
	
	@Override	
    public int  numfornextorback(WorkImgVO vo) {
		
		return workDAO.numfornextorback(vo);
	}
	
	
	public void insertImg(WorkImgVO vo) {
		workDAO.insertImg(vo);
		
	}


}
