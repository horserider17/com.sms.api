package com.iqsolutions.sms.services;

import java.util.Map;

import com.iqsolutions.sms.dtos.LoginRequestDTO;



public interface LoginService {

	Map<String, Object> checkLogin(LoginRequestDTO LoginRequestDTO);

}

