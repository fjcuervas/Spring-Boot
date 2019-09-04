package com.example.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Person;

@Repository
public interface IPersonRepo extends JpaRepository<Person, Long>{

}
