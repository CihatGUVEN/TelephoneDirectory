package com.example.telephonedirectory.repository;

import com.example.telephonedirectory.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {

}