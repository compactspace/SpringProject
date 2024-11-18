package com.spring.finall.adminRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.finall.admindomain.UserEntity;

public interface UserInfoRepository extends JpaRepository<UserEntity,Long> {

}
