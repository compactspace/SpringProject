package com.spring.finall.adminRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.finall.admindomain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
