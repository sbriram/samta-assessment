package com.samta.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samta.entities.Question;

public interface AppRepository extends JpaRepository<Question, Long> {

}
