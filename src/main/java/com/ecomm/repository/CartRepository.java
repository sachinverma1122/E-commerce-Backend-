package com.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomm.Entity.Cart;
import com.ecomm.Entity.Orders;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value ="SELECT * FROM ecommerse.Cart WHERE user_id = :user_id", nativeQuery = true)
	List<Cart> findByUserId(@Param("user_id") Long user_id);
}
