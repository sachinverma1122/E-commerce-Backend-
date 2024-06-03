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
import com.ecomm.Service.impl.SignUPServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/signUp")

public class SignUPController {

	@Autowired
	private SignUPServiceImpl signUPServiceImpl;

	@PostMapping
	public ResponseEntity<SignUPDto> createUser(@RequestBody SignUPDto signUPDto) {
		SignUPDto save = signUPServiceImpl.createSignUP(signUPDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	@GetMapping("/seller")
	public ResponseEntity<SignUPDto> loginUser(@Param("email") String email,@Param("password") String password){
		SignUPDto login = signUPServiceImpl.login(email, password);
		return ResponseEntity.status(HttpStatus.OK).body(login);

		
		
	}
}
