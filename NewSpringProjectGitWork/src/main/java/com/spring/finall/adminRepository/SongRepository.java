package com.spring.finall.adminRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.finall.admindomain.Song;

public interface SongRepository extends JpaRepository<Song, Long> {
	
	//우선 문법 보다 아래 쿼리어노테이션 이하를 지우면
	//person 테이블이 10번 이나 출력된다.!! 씨발 알겠는데 정리를 못하겟따.
//	@Query("select s from Song s join fetch s.person")
//	List<Song> findAll();
	
	List<Song> findAll();
}