package com.example.javi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 
import com.example.javi.entity.Author;
 
 
@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, Long>{
 
}