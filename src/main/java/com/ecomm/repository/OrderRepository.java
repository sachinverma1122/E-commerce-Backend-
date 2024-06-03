package com.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomm.Entity.Orders;
import com.ecomm.Entity.User;



@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	@Query(value ="SELECT * FROM orders WHERE user_id = :user_id", nativeQuery = true)
	List<Orders> findByUserId(@Param("user_id") Long user_id);

}
