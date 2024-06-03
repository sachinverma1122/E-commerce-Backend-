package com.ecomm.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Dto.SignUPDto;
import com.ecomm.Dto.UserDto;
import com.ecomm.Entity.SignUp;
import com.ecomm.Entity.User;
import com.ecomm.Service.UserService;
import com.ecomm.repository.SignUpRepository;
import com.ecomm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		 User save = userRepository.save(user);
		 UserDto userDto2 = new UserDto();
		 userDto2.setId(save.getId());
		 userDto2.setName(save.getName());
		 userDto2.setEmail(save.getEmail());
		 userDto2.setPassword(save.getPassword());
		return userDto2;
	}

	@Override
	public UserDto login(String email, String password) {
		User EmailAndPassword = userRepository.findByEmailAndPassword(email, password);
		UserDto dto = new UserDto();
		if (EmailAndPassword != null) {
			dto.setEmail(EmailAndPassword.getEmail());
			dto.setPassword(EmailAndPassword.getPassword());
			dto.setId(EmailAndPassword.getId());
			dto.setName(EmailAndPassword.getName());
		}
		return dto;
	}

}
