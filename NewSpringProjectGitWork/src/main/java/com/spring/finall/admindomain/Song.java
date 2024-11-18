package com.spring.finall.admindomain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.finall.admindto.ResSongDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

//@ToString(of = {"id", "title"})
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String singer;

	@ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name = "person_id")
	@Access(AccessType.FIELD)
	private Person person;

	
	
	public ResSongDTO toResponseDTO (Song song) {
		
		ResSongDTO resdto= new ResSongDTO(song);
		resdto.setSong(song);
		resdto.setId(song.getId());		
		resdto.setSinger(song.getSinger());
		resdto.setTitle(song.getTitle());
		resdto.setPerson(song.getPerson());
		return resdto;
	}
	
	
	
	@Builder
	public Song(String title, String singer, Person person) {
		System.out.println(" Person person->>" + person);
		this.title = title;
		this.singer = singer;
		this.person = person;
	}

	public void updatePerson(Person person) {
		this.person = person;
	}
}