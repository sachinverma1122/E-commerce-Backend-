package com.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomm.Entity.Product;
import com.ecomm.Entity.SignUp;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	
	@Query(value = "SELECT * FROM ecommerse.product " +
            "WHERE name LIKE %:keyword% ", nativeQuery = true)
    List<Product> searchProducts(@Param("keyword") String keyword);
}
