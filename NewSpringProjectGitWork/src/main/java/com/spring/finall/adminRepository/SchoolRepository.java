package com.spring.finall.adminRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.finall.admindomain.School;

public interface SchoolRepository extends JpaRepository<School,Long> {

}
