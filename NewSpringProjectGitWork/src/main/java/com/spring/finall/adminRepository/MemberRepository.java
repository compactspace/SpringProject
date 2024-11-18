package com.spring.finall.adminRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.finall.admindomain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
