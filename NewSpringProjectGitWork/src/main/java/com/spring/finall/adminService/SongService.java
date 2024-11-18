package com.spring.finall.adminService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.finall.adminRepository.SongRepository;
import com.spring.finall.admindomain.Person;
import com.spring.finall.admindomain.Song;
import com.spring.finall.admindto.PersonDTO;
import com.spring.finall.admindto.ResSongDTO;

@Service("SongService")
public class SongService {
	@Autowired
	SongRepository songRepository;

	@Autowired
	EntityManager entityManager;
	public HashMap<String,Object> showlist() {

		List<Song> songslist = songRepository.findAll();
		// 레이지가 붙어 있는걸 get 해도 않되는데 흠
		
		List<PersonDTO> resdtolist= new ArrayList();
		for (Song s : songslist) {	
			
			Song songs = entityManager.getReference(Song.class,s.getId());	
			
			
			boolean 송은프록시아님 = entityManager.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(songs);

			System.out.println("송은프록시아님: " + 송은프록시아님);
			System.out.println("Proxy = " + songs.getClass().getName());			
			
			Person person=s.getPerson();
			person.getId();	
			person.getName();
			person.getSongs();
			System.out.println("person:"+person+"person.getId() :"+person.getId()+" person.getName():"+person.getName()+" person.getSongs();:"+person.getSongs());
			
			System.out.println("강제 초기화 결과는??..."+Hibernate.isInitialized(s.getPerson()));
			boolean 펄슨프록시강제초기화시도 = entityManager.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(person);

			System.out.println("송속의펄슨은프록시: " + 펄슨프록시강제초기화시도);
			
			resdtolist.add(person.toResposeDTO(person.getId(), person.getName()));
			
			
			
			
			Person ps = entityManager.getReference(Person.class, s.getPerson().getId());		
			
			boolean 송속의펄슨은프록시 = entityManager.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(ps);

			System.out.println("송속의펄슨은프록시: " + 송속의펄슨은프록시);
			System.out.println("Proxy = " + ps.getClass().getName());

		}
		System.out.println("--------------------------------------------구분선-----------------------------------------------------");

		HashMap<String,Object> map = new HashMap(); 
		map.put("songslist",songslist);
		map.put("personlist",resdtolist);

		return map;
	}
	
	

	public List<ResSongDTO> showlist2() {
		
		

		List<Song> songslist = songRepository.findAll();
		
		List<ResSongDTO> ResSongDTO = new ArrayList();
	
		for (Song s : songslist) {		
			
			
			Person person=s.getPerson();
			person.getId();	
			person.getName();
			person.getSongs();
			//System.out.println("person:"+person+"person.getId() :"+person.getId()+" person.getName():"+person.getName()+" person.getSongs();:"+person.getSongs());
			
			System.out.println("송속의 펄슨 강제초기화??..."+Hibernate.isInitialized(s.getPerson()));
			boolean 펄슨프록시강제초기화시도 = entityManager.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(person);
			System.out.println("송속의 펄슨 엔티티?: " + 펄슨프록시강제초기화시도);
			
			
			
			Person ps = entityManager.getReference(Person.class, s.getPerson().getId());		
			
			boolean 송속의펄슨은프록시 = entityManager.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(ps);

			System.out.println("송속의펄슨은프록시: " + 송속의펄슨은프록시);
			System.out.println("Proxy = " + ps.getClass().getName());
			s.setPerson(ps);
			songslist.clear();
			songslist.add(s);
			
			
			ResSongDTO.add(s.toResponseDTO(s));
			
			
			
		}
		System.out.println("--------------------------------------------구분선-----------------------------------------------------");

	

		return ResSongDTO;
	}

}
