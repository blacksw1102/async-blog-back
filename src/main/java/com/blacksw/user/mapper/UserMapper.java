package com.blacksw.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import com.blacksw.user.vo.User;

@Mapper
public interface UserMapper {

	public User selectUserByEmail(String email);
	
}
