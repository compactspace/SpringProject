package com.spring.finall.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.finall.WorkImgVO;

@Repository
public class WorkDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<WorkImgVO> getworkList(WorkImgVO vo) {
		//mybatis 객체에 접근해서 메소드 selectList 를 불러와서
		//첫 매개변수에는 메퍼설정파일의  namespace="BoardDAO" 과 각 태그명들 을 매개변수로 
		//둘 매개변수에는 말그대로 vo
		
		vo.setNumfornextorback(numfornextorback(vo));
		return mybatis.selectList("WorkImgDAO.selectworkimg",vo);
	}

	public int  numfornextorback(WorkImgVO vo) {
		
		return mybatis.selectOne("WorkImgDAO.numfornextorback",vo);
	}

	
	public List<WorkImgVO> graterthanonepage(WorkImgVO vo) {
		//mybatis 객체에 접근해서 메소드 selectList 를 불러와서
		//첫 매개변수에는 메퍼설정파일의  namespace="BoardDAO" 과 각 태그명들 을 매개변수로 
		//둘 매개변수에는 말그대로 vo
		
		
		return mybatis.selectList("WorkImgDAO.graterthanonepage",vo);
	}
	
	
	
	
	
	
	
	
	public void insertImg(WorkImgVO vo) {
	
		
	
		 mybatis.insert("WorkImgDAO.insertImg",vo);
	}
	
	
}
