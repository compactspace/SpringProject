package com.spring.finall.adminRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.finall.admindomain.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
	
	//솔직히 씨발 좆도 모르겠음 지 꼴리는 대로 다 하니..
	Optional<Student> findById(Long id);
	
	List<Student> findAllById(Long id);
}
