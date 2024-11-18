package com.spring.finall.admindomain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.finall.admindto.PersonDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@ToString(of = {"id", "name"})
public class Person {
	@Access(AccessType.FIELD) 
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @OneToMany(mappedBy = "person")
    @JsonIgnore
    private List<Song> songs = new ArrayList<>();

    
    
    public PersonDTO toResposeDTO(Long id, String name) {
    	System.out.println("toResposeDTO id 와 name은"+id+"  "+name);
    	PersonDTO resdto = new PersonDTO();
    	resdto.setId(id);
    	resdto.setName(name);
    	return resdto;
    }
    
    
    
    @Builder
    public Person(String name, List<Song> playList) {
    
        this.name = name;
        if (playList != null) {
            this.songs = playList;
        }
    }

    public void addSong(Song song) {
        this.songs.add(song);
        song.updatePerson(this);
    }
}