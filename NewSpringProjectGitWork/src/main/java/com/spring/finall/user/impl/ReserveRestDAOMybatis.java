package com.spring.finall.user.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ReserveRestDAOMybatis {
	

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public Integer restOneDayClass(HttpServletRequest req) {
		System.out.println("클래스번호   "+req.getParameter("onedayclass_num"));
		System.out.println("개설강의날짜   "+req.getParameter("openday"));
		String onedayclass_num=req.getParameter("onedayclass_num");
		String  openday=req.getParameter("openday");
		Map<String ,Object> map = new HashMap<>();
		map.put("onedayclass_num",onedayclass_num);
		map.put("openday",openday);
		
		
	Integer result=(Integer)mybatis.selectOne("ReserveRestVO.reserverest", map);
	
	System.out.println("받아온 결과 값은?");
	System.out.println(result);
	
	if(result==null || result==0 ) {
		return 0;
	}
		
	else {
		return result;
		
	}
		
	} 
	
	//이는 결제 성공후 자리수 감소 업데이트임
	public void reserverestupdate(HttpServletRequest req) {		
		String rest=req.getParameter("rest");
		String onedayclass_num=req.getParameter("onedayclass_num");
		String openday=req.getParameter("openday");
		System.out.println("자리수->"+rest+"  클래스번호->>"+onedayclass_num+"  개설강의날짜"+openday);
		Map<String,Object> map = new HashMap<>();
		map.put("rest", rest);
		map.put("onedayclass_num", onedayclass_num);
		map.put("openday",openday);

		
		mybatis.update("ReserveRestVO.reserverestupdate", map);
		
	};	//이는 결제 성공후 자리수 감소 업데이트 종료
	
	
	
	
	public void reserverestpaycancelupdate(HttpServletRequest req) {
		String onedayclass_num=req.getParameter("onedayclass_num");
		String openday=req.getParameter("openday");
		System.out.println("클래스번호 "+onedayclass_num+" 개설강의 날짜"+openday);
		Map<String,Object> map = new HashMap<>();	
		
		map.put("onedayclass_num", onedayclass_num);
		map.put("openday",openday);
		
		Integer result=(Integer)mybatis.selectOne("ReserveRestVO.reserverest", map);
		
		
		map.put("rest",result);
	
		mybatis.update("ReserveRestVO.reserverestpaycancelupdate", map);
		
	};
	
	
	
}
