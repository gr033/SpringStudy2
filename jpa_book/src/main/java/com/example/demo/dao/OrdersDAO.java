package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.OrdersVO;

import jakarta.transaction.Transactional;
@Repository
public interface OrdersDAO extends JpaRepository<OrdersVO, Integer> {
	
	@Query("select nvl(max(orderid),0)+1 from OrdersVO")
	public int getNextNo();
	
	
	//여기에는 표준 sql이 아니라 sysdate(오라클 언어) native query(특정db에 맞는 언어)를 
	//사용하기 때문에 이럴 때는 엔티티가 아니라 테이블 이름을 넣어야 한다.
	@Modifying
	@Query(value="insert into orders o(o.orderid, o.custid, o.bookid, o.saleprice, o.orderdate) values (:#{#o.orderid}, :#{#o.customer.custid}, :#{#o.book.bookid}, :#{#o.saleprice}, sysdate)", nativeQuery = (true))
	@Transactional
	public void insert(@Param("o") OrdersVO o);
	
	public List<OrdersVO> findAllByOrderByOrderid();
}
