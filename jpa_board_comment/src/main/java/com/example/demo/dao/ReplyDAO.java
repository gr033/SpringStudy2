package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Reply;

@Repository
public interface ReplyDAO extends JpaRepository<Reply, Integer> {
	
	
	
	@Query(value = "update reply set b_step = b_step +1 where b_ref = ?1 and b_step > ?2", nativeQuery = true)
	public void updateStep(int b_ref, int b_step);
	
	@Query("select nvl(max(cno),0) + 1 from Reply")
	public int getNextCno();
	
	@Query(value = "select * from reply where no=?1 order by b_ref desc, b_step", 
	nativeQuery = true)
	public List<Reply> findByNo(int no);
}