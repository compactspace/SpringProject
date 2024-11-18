package com.spring.finall.adminService;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.finall.adminRepository.UserInfoRepository;

public class UserInfoService {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	public void test() {
		userInfoRepository.findAll();
	}

}
