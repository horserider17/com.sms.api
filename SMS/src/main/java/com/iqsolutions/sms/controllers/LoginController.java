package com.iqsolutions.sms.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iqsolutions.sms.dtos.LoginRequestDTO;
import com.iqsolutions.sms.dtos.LoginResponseDTO;
import com.iqsolutions.sms.services.LoginService;
import com.iqsolutions.sms.utils.WebResponseEntity;


@Controller
@CrossOrigin(origins="*")
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private LoginService loginservice;

	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<WebResponseEntity<LoginResponseDTO>>  getloginDetails(@RequestBody LoginRequestDTO LoginRequestDTO) {
		
		
		Map<String,Object> map=loginservice.checkLogin(LoginRequestDTO);		
		
	
		@SuppressWarnings("rawtypes")
		WebResponseEntity<LoginResponseDTO> webentity= new WebResponseEntity((Integer)map.get("status") , (String) map.get("message"), (LoginResponseDTO) map.get("response"));
		return  new ResponseEntity(webentity, HttpStatus.OK);
		
		
	}

	
	
}
