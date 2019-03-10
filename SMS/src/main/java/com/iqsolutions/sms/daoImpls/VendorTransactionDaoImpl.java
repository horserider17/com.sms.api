package com.iqsolutions.sms.daoImpls;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqsolutions.sms.daos.VendorTransactionDao;
import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.entities.VendorTransactionsEntity;

@Component
public class VendorTransactionDaoImpl implements VendorTransactionDao {

	@Autowired
	private SessionFactory _sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ProviderEntity> getVendorTransactions() {
		return _sessionFactory.getCurrentSession().createCriteria(VendorTransactionsEntity.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	public void saveVendorTransaction(VendorTransactionsEntity vendorTransactionsEntity) {
		vendorTransactionsEntity.setCreatedAt(new Date());
		_sessionFactory.getCurrentSession().save(vendorTransactionsEntity);
	}

}
