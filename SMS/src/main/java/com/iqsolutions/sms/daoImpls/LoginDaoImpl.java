package com.iqsolutions.sms.daoImpls;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqsolutions.sms.daos.LoginDao;
import com.iqsolutions.sms.entities.ProviderEntity;

@Component
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public ProviderEntity checkLogin(ProviderEntity providerEntity){
		org.hibernate.Session session = sessionFactory.getCurrentSession();
		
		ProviderEntity resu=(ProviderEntity)session.createCriteria(ProviderEntity.class).add(Restrictions.eq("mobileNumber", providerEntity.getMobileNumber())).uniqueResult();
		
	//	ProviderEntity result= (ProviderEntity) session.createCriteria(ProviderEntity.class).add(Restrictions.eq("mobileNumber", providerEntity.getMobileNumber()))
		//		.uniqueResult();

System.out.println("result"+resu);
		
			return resu;


	}
}