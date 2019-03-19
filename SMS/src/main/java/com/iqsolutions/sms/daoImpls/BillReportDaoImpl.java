package com.iqsolutions.sms.daoImpls;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqsolutions.sms.daos.BillReportDao;
import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.entities.VendorDeductionsEntity;
import com.iqsolutions.sms.entities.VendorProductsEntity;
import com.iqsolutions.sms.entities.VendorTransactionsEntity;
import com.iqsolutions.sms.utils.Constants;

@Component
public class BillReportDaoImpl implements BillReportDao {

	@Autowired
	private SessionFactory _sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getProviderDetails(int providerId) {
		return (Map<String, Object>) _sessionFactory.getCurrentSession().createCriteria(ProviderEntity.class)
				.add(Restrictions.eq(Constants.PROVIDER_ID, providerId))
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.COMPANY_NAME).as(Constants.COMPANY_NAME))
						.add(Projections.property(Constants.CAPTION).as(Constants.CAPTION))
						.add(Projections.property(Constants.ADDRESS).as(Constants.ADDRESS))
						.add(Projections.property(Constants.FIRST_NAME).as(Constants.FIRST_NAME))
						.add(Projections.property(Constants.LAST_NAME).as(Constants.LAST_NAME))
						.add(Projections.property(Constants.MOBILE_NUMBER).as(Constants.MOBILE_NUMBER)))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).uniqueResult();	
		}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getBillTransactionDetails(int transactionId) {
		return (Map<String, Object>) _sessionFactory.getCurrentSession().createCriteria(VendorTransactionsEntity.class)
				.add(Restrictions.eq(Constants.VENODR_TRANSACTION_ID, transactionId))
				.createAlias(Constants.VENDORS_ENTITY, Constants.VENDORS_ENTITY)
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.TRANSACTION_DATE).as(Constants.TRANSACTION_DATE))
						.add(Projections.property(Constants.VENDORS_ENTITY_VENDOR_NAME).as(Constants.VENDOR_NAME))
						.add(Projections.property(Constants.VENODR_TRANSACTION_ID).as(Constants.VENODR_TRANSACTION_ID))
						.add(Projections.property(Constants.TOTAL_AMOUNT).as(Constants.TOTAL_AMOUNT))
						.add(Projections.property(Constants.ADVANCE).as(Constants.ADVANCE)))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).uniqueResult();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllProductDetails(int transactionId) {
		List<Map<String, Object>> products = _sessionFactory.getCurrentSession().createCriteria(VendorProductsEntity.class)
				.add(Restrictions.eq(Constants.VENODR_TRANSACTION_ID, transactionId))
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.PRODUCT_QTY).as(Constants.PRODUCT_QTY))
						.add(Projections.property(Constants.PRODUCT_PRICE).as(Constants.PRODUCT_PRICE)))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
		
		for (Map<String, Object> product : products) {
			product.put("productAmount", ((Double) product.get(Constants.PRODUCT_QTY))*((Double) product.get(Constants.PRODUCT_PRICE)));
		}
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllBillDeductions(int transactionId) {
		return _sessionFactory.getCurrentSession().createCriteria(VendorDeductionsEntity.class)
				.createAlias(Constants.MASTER_DEDUCTION_TYPE_ENTITY, Constants.MASTER_DEDUCTION_TYPE_ENTITY)
				.add(Restrictions.eq(Constants.VENODR_TRANSACTION_ID, transactionId))
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.DEDUCTION_TYPE_ID).as(Constants.DEDUCTION_TYPE_ID))
						.add(Projections.property(Constants.MASTER_DEDUCTION_TYPE_ENTITY_DEDUCTION_TYPE)
								.as(Constants.DEDUCTION_TYPE))
						.add(Projections.property(Constants.DEDUCTION_VALUE).as(Constants.DEDUCTION_VALUE)))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public void updateBillGenerated(int transactionId) {
		_sessionFactory.getCurrentSession().createQuery("UPDATE VendorTransactionsEntity set isBillGenerated = :isBillGenerated "  + 
				"WHERE vendorTransactionId = :vendorTransactionId")
		.setParameter("isBillGenerated", true)
		.setParameter("vendorTransactionId", transactionId).executeUpdate();
	}

}
