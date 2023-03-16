package com.springbootacademy.project1.repo;

import com.springbootacademy.project1.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface BookRepo extends JpaRepository<Books,Integer> {

    List<Books> findAllByActiveStatusAndBookValue (boolean status, double price);
}
