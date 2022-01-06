package com.blacksw.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blacksw.user.service.UserService;
import com.blacksw.user.vo.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

	 @Autowired
	 private UserService userService;

	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		return userService.findUserDetailsById(email);
	}
	 
}
