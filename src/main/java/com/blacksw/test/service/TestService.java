package com.blacksw.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blacksw.test.mapper.TestMapper;
import com.blacksw.test.vo.TestVo;

@Service
public class TestService {
	
	@Autowired
	public TestMapper mapper;

	public List<TestVo> selectTest() {
		return mapper.selectTest();
	}
	
}
