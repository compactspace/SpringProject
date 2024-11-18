package com.spring.finall.admindto;

import com.spring.finall.admindomain.Person;
import com.spring.finall.admindomain.Song;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResSongDTO {

	public Long id;
	public String title;
	public String singer;
	public Person person;
	public Song song;
	
	public ResSongDTO (Song song) {
		System.out.println("song---->"+song);
		this.id=song.getId();
		this.title=song.getTitle();
		this.singer=song.getSinger();
		this.person=song.getPerson();
		this.song=song;
	}
	
	

}
