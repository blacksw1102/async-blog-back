package com.blacksw.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	/*
	@Autowired
	private TestService testService;
	*/
	
	@GetMapping("/hello")
	public String hello() {
		return "hello swagger..!\n";
	}
	
	/*
	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public List<TestVo> test() throws Exception {
		List<TestVo> testList = testService.selectTest();
		return testList;
	}
	*/
	
	
}
