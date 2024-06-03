package com.ecomm.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Dto.SignUPDto;
import com.ecomm.Entity.SignUp;
import com.ecomm.Service.SignUPService;
import com.ecomm.repository.SignUpRepository;

@Service
public class SignUPServiceImpl implements SignUPService {

	@Autowired
	public SignUpRepository signUpRepository;
	private SignUp save;

	@Override
	public SignUPDto createSignUP(SignUPDto signUPDto) {
		SignUp signUp = new SignUp();
		signUp.setId(signUPDto.getId());
		signUp.setName(signUPDto.getName());
		signUp.setEmail(signUPDto.getEmail());
		signUp.setPassword(signUPDto.getPassword());
		save = signUpRepository.save(signUp);
		SignUPDto signUPDto2 = new SignUPDto();
		signUPDto2.setId(save.getId());
		signUPDto2.setName(save.getName());
		signUPDto2.setEmail(save.getEmail());
		signUPDto2.setPassword(save.getPassword());
		return signUPDto2;
	}

	@Override
	public SignUPDto login(String email, String password) {
		SignUp EmailAndPassword = signUpRepository.findByEmailAndPassword(email, password);
		SignUPDto dto = new SignUPDto();
		if (EmailAndPassword != null) {
			dto.setEmail(EmailAndPassword.getEmail());
			dto.setPassword(EmailAndPassword.getPassword());
			dto.setId(EmailAndPassword.getId());
			dto.setName(EmailAndPassword.getName());
		}
		return dto;

	}

}
