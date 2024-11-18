package com.spring.finall.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.spring.finall.config.testEntity.BookEntity;

@Service("AdminRepository")
public interface AdminRepository extends JpaRepository<BookEntity, Integer> {
	public List<BookEntity> findByName(String name); //
}
