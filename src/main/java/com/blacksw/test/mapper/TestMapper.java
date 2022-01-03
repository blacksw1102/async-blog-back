package com.blacksw.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.blacksw.test.vo.TestVo;

@Repository
@Mapper
public interface TestMapper {

	public List<TestVo> selectTest();
	
}
