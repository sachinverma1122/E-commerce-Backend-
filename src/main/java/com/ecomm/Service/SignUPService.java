package com.ecomm.Service;

import org.springframework.stereotype.Service;

import com.ecomm.Dto.SignUPDto;

public interface SignUPService {

	public SignUPDto createSignUP(SignUPDto signUPDto);
	public SignUPDto login(String email, String password);
}
