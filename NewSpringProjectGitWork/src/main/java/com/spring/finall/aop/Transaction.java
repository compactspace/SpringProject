package com.spring.finall.aop;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class Transaction {	
	

	public void x() {
		
		
		throw new RuntimeException("런타임에러 고의로 만들기!!");
		
		
	}
	

}
