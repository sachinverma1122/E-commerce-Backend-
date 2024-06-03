package com.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.Dto.SignUPDto;
import com.ecomm.Dto.UserDto;
import com.ecomm.Service.impl.SignUPServiceImpl;
import com.ecomm.Service.impl.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto save = userServiceImpl.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	@GetMapping("/seller")
	public ResponseEntity<UserDto> loginUser(@Param("email") String email,@Param("password") String password){
		UserDto login = userServiceImpl.login(email, password);
		return ResponseEntity.status(HttpStatus.OK).body(login);

	}
}
