package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Member;

@Repository
public interface MemberDAO extends JpaRepository<Member, String> {

	@Query(value = "select * from member where id=?1 and pwd=?2", nativeQuery = true)
	public Member isMember(String id, String pwd);
}
