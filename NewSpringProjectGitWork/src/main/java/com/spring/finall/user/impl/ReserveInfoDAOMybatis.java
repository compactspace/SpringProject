package com.spring.finall.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.finall.user.ReserveInfoVO;

@Repository
public class ReserveInfoDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;

	public boolean insertreserveinfo(ReserveInfoVO vo) {

		Object result = mybatis.insert("ReserveInfoVO.insertreserveinfo", vo);

		Integer executerow = (Integer) result;

		if (executerow == 0) {

			return true;

		} else {

			return false;
		}

	};

	
	public boolean inscheckreserveinfo(ReserveInfoVO vo) {

		Object result = mybatis.selectOne("ReserveInfoVO.checkreserinfo", vo);

		Integer executerow = (Integer) result;

		if (executerow == 0) {

			return true;

		} else {

			return false;

		}

	}
	
	//마이베티스 조인문 사용법을 몰라서
	//ReserveInfoVO-mapping.xml 에서 innerjoin을 한뒤 
	// resultType을 java.util.HashMap으로 설정함(Map도 결과는동일)
	// 그러면 mybatis.selectList 가 각 인덱스자리에 HashMap형태를 넣어서 포장해온다.
	public List<Object> myreserveinfo(HttpServletRequest req){
		
		Map<String,Object> map = new HashMap<>();
		map.put("user_code", req.getParameter("user_code"));		
	   List<Object> result =mybatis.selectList("ReserveInfoVO.myreserveinfo", map);
		
//	   System.out.println("리졀트"+result);
//	   System.out.println("리졀트 투스트링"+result.toString());	
		return result;
		
	}
	
	
	public void paystatusupdate(HttpServletRequest req) {
		String reserveinfo_num=req.getParameter("reserveinfo_num");
		System.out.println("예약 번호는"+reserveinfo_num);
		Map<String, Object> map = new HashMap<>();
		map.put("reserveinfo_num",reserveinfo_num);
		mybatis.update("ReserveInfoVO.paystatusupdate", map);
		
		
	}
	

}
