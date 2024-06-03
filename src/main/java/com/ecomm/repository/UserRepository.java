package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomm.Entity.SignUp;
import com.ecomm.Entity.User;

@Repository	
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value ="SELECT * FROM ecommerse.user WHERE user.email = :email and user.password =:password",nativeQuery = true)
    User findByEmailAndPassword(@Param("email") String email , @Param("password") String password);
}
