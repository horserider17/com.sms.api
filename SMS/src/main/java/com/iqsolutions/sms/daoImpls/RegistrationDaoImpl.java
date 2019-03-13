package com.iqsolutions.sms.daoImpls;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.iqsolutions.sms.daos.RegistrationDao;
import com.iqsolutions.sms.entities.ProviderEntity;
@Component
public class RegistrationDaoImpl implements RegistrationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	  @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public ProviderEntity setUserDetails(ProviderEntity ProviderEntity){
		org.hibernate.Session session = sessionFactory.getCurrentSession();
		


		ProviderEntity.setPassword(bCryptPasswordEncoder.encode(ProviderEntity.getPassword()));
		System.out.println("RegisterEntity"+ProviderEntity.getPassword());
		int n=	(Integer) session.save(ProviderEntity);
		System.out.println("save"+n);
			return null; 

	}
}



