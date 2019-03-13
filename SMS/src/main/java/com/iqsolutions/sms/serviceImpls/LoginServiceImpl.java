package com.iqsolutions.sms.serviceImpls;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqsolutions.sms.daos.LoginDao;
import com.iqsolutions.sms.dtos.LoginRequestDTO;
import com.iqsolutions.sms.dtos.LoginResponseDTO;
import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.services.LoginService;



@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao logindao;
	
	  @Autowired
	   private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public Map<String,Object> checkLogin(LoginRequestDTO LoginRequestDTO) {
		ModelMapper mapper=new ModelMapper();
		
		ProviderEntity ProviderEntity=mapper.map(LoginRequestDTO, ProviderEntity.class);
		ProviderEntity login=logindao.checkLogin(ProviderEntity);
   Map<String,Object>map=new HashMap<String, Object>();
   LoginResponseDTO LoginResponseDTO=null;
   if(login!=null) {
    LoginResponseDTO=mapper.map(login, LoginResponseDTO.class);
   }
   String message;
   Integer status=2000;
  
		if(login==null) {
						
			message="resource not found";
			status=4004;
			
		}else if(!bCryptPasswordEncoder.matches(LoginRequestDTO.getPassword(), login.getPassword())){

			message="Unauthorized";
			LoginResponseDTO=null;
			status=4001;

		}else {
		
			message="success";
			
		}
		
	
		
		map.put("message", message);
		map.put("response", LoginResponseDTO);
		map.put("status", status);
		return map;
	}


}
