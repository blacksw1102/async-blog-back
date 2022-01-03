package com.blacksw.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blacksw.test.service.TestService;
import com.blacksw.test.vo.TestVo;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello swagger..!\n";
	}
	
	@GetMapping("/list")
	public List<TestVo> test() throws Exception {
		List<TestVo> testList = testService.selectTest();
		return testList;
	}
	
}
