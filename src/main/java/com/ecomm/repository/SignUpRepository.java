package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomm.Dto.SignUPDto;
import com.ecomm.Entity.SignUp;

import jakarta.transaction.Transactional;
@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Long> {
	
	
	@Query(value ="SELECT * FROM ecommerse.sign_up WHERE sign_up.email = :email and sign_up.password =:password",nativeQuery = true)
    SignUp findByEmailAndPassword(@Param("email") String email , @Param("password") String password);
}
