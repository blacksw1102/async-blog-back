package com.blacksw.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blacksw.user.mapper.UserMapper;
import com.blacksw.user.vo.User;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User findUserDetailsById(String email) {
		return userMapper.selectUserByEmail(email);
	}
	
}
