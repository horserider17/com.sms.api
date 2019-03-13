package com.iqsolutions.sms.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqsolutions.sms.daos.RegistrationDao;
import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.services.RegistrationService;
@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	private RegistrationDao registrationDao;



	@Override
	@Transactional
	public ProviderEntity setUserDetails(ProviderEntity ProviderEntity) {		
   
		return registrationDao.setUserDetails(ProviderEntity);
	}


}
