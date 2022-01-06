package com.blacksw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blacksw.model.response.CommonResult;
import com.blacksw.model.response.ListResult;
import com.blacksw.model.response.SingleResult;

@Service
public class ResponseService {
	
	// 단건 결과 처리
	public <T> SingleResult<T> getSingleResult(T data) {
		SingleResult <T> result = new SingleResult<>();
		result.setData(data);
		setSuccessResult(result);
		return result;
	}
	
	// 리스트 결과 처리
	public <T> ListResult<T> getListResult(List<T> list) {
		ListResult<T> result = new ListResult<>();
		result.setData(list);
		setSuccessResult(result);
		return result;
	}
	
	// 성공 결과만 처리
	public CommonResult getSuccessResult() {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		return result;
	}
	
	// 실패 결과만 처리
	public CommonResult getFailResult() {
		CommonResult result = new CommonResult();
		setFailResult(result);
		return result;
	}
	
	// 성공 결과 set
	private void setSuccessResult(CommonResult result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(CommonResponse.SUCCESS.getMsg());
	}
	
	// 실패 결과 set
	private void setFailResult(CommonResult result) {
		result.setSuccess(false);
		result.setCode(CommonResponse.FAIL.getCode());
		result.setMsg(CommonResponse.FAIL.getMsg());
	}

}
