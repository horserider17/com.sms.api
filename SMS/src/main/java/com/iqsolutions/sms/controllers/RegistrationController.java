package com.iqsolutions.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.services.RegistrationService;
import com.iqsolutions.sms.utils.WebResponseEntity;


@Controller
@RequestMapping("/api/register")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;



	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<WebResponseEntity<ProviderEntity>> setUserDetails(@RequestBody ProviderEntity ProviderEntity) {
		
		try {
			registrationService.setUserDetails(ProviderEntity);
		WebResponseEntity<ProviderEntity> webentity= new WebResponseEntity<ProviderEntity>(200,"success");

		//WebResponseEntity<User> webentity= new WebResponseEntity(200 , "success", registrationService.setUserDetails(user));
		return  new ResponseEntity(webentity, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getStackTrace());		
			return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
}

	}



}


