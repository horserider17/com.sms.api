package com.iqsolutions.sms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.iqsolutions.sms.utils.WebResponseEntity;

public class SmsBaseController {

	@SuppressWarnings("rawtypes")
	public ResponseEntity<WebResponseEntity> BuildResponse(String message)
	{
		return new ResponseEntity<WebResponseEntity>(new WebResponseEntity(2001, message), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	public <T> ResponseEntity<WebResponseEntity> BuildResponse(String message, T data)
	{	System.out.println(data);
		return new ResponseEntity<WebResponseEntity>(new WebResponseEntity(2001, message, data), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity<WebResponseEntity> BuildErrorResponse()
	{
		return  new ResponseEntity<WebResponseEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
