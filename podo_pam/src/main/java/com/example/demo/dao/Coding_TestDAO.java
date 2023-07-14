package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Coding_Test;
@Repository
public interface Coding_TestDAO extends JpaRepository<Coding_Test, Integer> {

}
