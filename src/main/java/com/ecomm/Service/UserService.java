package com.ecomm.Service;

import com.ecomm.Dto.SignUPDto;
import com.ecomm.Dto.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);
	public UserDto login(String email, String password);
}
