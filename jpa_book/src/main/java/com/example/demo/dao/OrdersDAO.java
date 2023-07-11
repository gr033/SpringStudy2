package com.example.demo.dao;

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
	
	@Modifying
	@Query(value="insert into OrdersVO o(o.orderid, o.custid, o.bookid, o.saleprice, o.orderdate) values (:#{#o.orderid}, :#{#o.customer.custid}, :#{#o.book.bookid}, :#{#o.saleprice}, sysdate)", nativeQuery = (true))
	@Transactional
	public void insert(@Param("o") OrdersVO o);
}
