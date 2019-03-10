package com.iqsolutions.sms.daoImpls;

import org.springframework.stereotype.Repository;

import com.iqsolutions.sms.daos.GeneralDAO;

@Repository("generalDAOImpl")
public class GeneralDAOImpl implements GeneralDAO {

//	@Autowired
//	private SessionFactory sessionFactory;
	
//	@Override
//	public Serializable getNextSequence(String sequenceName) {
//		final Query query = this.sessionFactory.getCurrentSession()
//				.createSQLQuery("SELECT nextval (:sequenceName) as nextval");
//		query.setParameter("sequenceName", sequenceName);
//		return (Serializable) query.uniqueResult();
//	}
	
	
}
