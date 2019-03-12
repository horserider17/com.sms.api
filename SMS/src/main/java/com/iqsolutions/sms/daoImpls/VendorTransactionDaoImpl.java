package com.iqsolutions.sms.daoImpls;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqsolutions.sms.daos.VendorTransactionDao;
import com.iqsolutions.sms.dtos.PostVendorBillDTO;
import com.iqsolutions.sms.dtos.VendorDeductionsDTO;
import com.iqsolutions.sms.dtos.VendorProductsDTO;
import com.iqsolutions.sms.entities.MasterDeductionsEntity;
import com.iqsolutions.sms.entities.VendorDeductionsEntity;
import com.iqsolutions.sms.entities.VendorProductsEntity;
import com.iqsolutions.sms.entities.VendorTransactionsEntity;
import com.iqsolutions.sms.entities.VendorsEntity;
import com.iqsolutions.sms.utils.Constants;

@Component
public class VendorTransactionDaoImpl implements VendorTransactionDao {

	@Autowired
	private SessionFactory _sessionFactory;
	
//	@Override
//	public double getHamaliCost(int providerId) {
//		return (Double) _sessionFactory.getCurrentSession().createCriteria(MasterDeductionsEntity.class)
//				.add(Restrictions.eq(Constants.PROVIDER_ID, providerId))
//				.add(Restrictions.eq(Constants.DEDUCTION_TYPE_ID, 1))
//				.add(Restrictions.eq(Constants.IS_ACTIVE, true))
//				.setProjection(Projections.property(Constants.DEDUCTION_VALUE)).uniqueResult();
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getMasterDedctions(int providerId) {
		System.out.println("deductions dao");
		return _sessionFactory.openSession().createCriteria(MasterDeductionsEntity.class)
				.createAlias(Constants.MASTER_DEDUCTION_TYPE_ENTITY, Constants.MASTER_DEDUCTION_TYPE_ENTITY, JoinType.INNER_JOIN)
				.add(Restrictions.eq(Constants.PROVIDER_ID, providerId))
				.add(Restrictions.eq(Constants.IS_ACTIVE, true))
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.MASTER_DEDUCTION_TYPE_ENTITY_DEDUCTION_TYPE).as(Constants.DEDUCTION_TYPE))
						.add(Projections.property(Constants.DEDUCTION_VALUE).as(Constants.DEDUCTION_VALUE))
						.add(Projections.property(Constants.DEDUCTION_TYPE_ID).as(Constants.DEDUCTION_TYPE_ID)))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllBills(int providerId) {
		System.out.println("bills :");
		return _sessionFactory.getCurrentSession().createCriteria(VendorTransactionsEntity.class)
				.createAlias(Constants.VENDORS_ENTITY, Constants.VENDORS_ENTITY, JoinType.INNER_JOIN)
				.add(Restrictions.eq(Constants.PROVIDER_ID, providerId))
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.VENDORS_ENTITY_VENDOR_NAME).as(Constants.VENDOR_NAME))
						.add(Projections.property(Constants.VENDORS_ENTITY_MOBILE_NUMBER).as(Constants.MOBILE_NUMBER))
						.add(Projections.property(Constants.VENODR_TRANSACTION_ID).as(Constants.VENODR_TRANSACTION_ID))
						.add(Projections.property(Constants.TRANSACTION_DATE).as(Constants.TRANSACTION_DATE))
						.add(Projections.property(Constants.TOTAL_AMOUNT).as(Constants.TOTAL_AMOUNT))
						.add(Projections.property(Constants.IS_BILL_GENERATOR).as(Constants.IS_BILL_GENERATOR)))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
	}
	
	@Override
	public void saveVendorTransaction(PostVendorBillDTO postVendorBillDTO) {
		Session session = _sessionFactory.getCurrentSession();
		VendorTransactionsEntity vendorTransactionsEntity = new VendorTransactionsEntity();	

		// getting vendor details
		int vendorId = getVendorId(postVendorBillDTO.getProviderid(), postVendorBillDTO.getMobilenumber());
		//checking whether the vendor already exist or not, if not exists creating new vendor
		if(vendorId == 0) {
			VendorsEntity vendorsEntity = new VendorsEntity();
			vendorsEntity.setVendorName(postVendorBillDTO.getVendorname());
			vendorsEntity.setMobileNumber(postVendorBillDTO.getMobilenumber());
			vendorsEntity.setCreatedAt(new Date());
			vendorsEntity.setProviderId(postVendorBillDTO.getProviderid());
			vendorId = (Integer) session.save(vendorsEntity);
		}
		vendorTransactionsEntity.setVendorId(vendorId);
		vendorTransactionsEntity.setProviderId(postVendorBillDTO.getProviderid());
		vendorTransactionsEntity.setAdvance(postVendorBillDTO.getAdvance());
		vendorTransactionsEntity.setTransactionDate(postVendorBillDTO.getTransactiondate());
		vendorTransactionsEntity.setCreatedAt(new Date());
		vendorTransactionsEntity.setTotalAmount(postVendorBillDTO.getTotalamount());
		vendorTransactionsEntity.setBillGenerated(false);
		int vendorTransactionId = (Integer) session.save(vendorTransactionsEntity);

		// saving products
		List<VendorProductsDTO> vendorProductsDTOs = postVendorBillDTO.getProducts();
		for (VendorProductsDTO vendorProductsDTO : vendorProductsDTOs) {
			VendorProductsEntity vendorProductsEntity = new VendorProductsEntity();
			vendorProductsEntity.setCreatedAt(new Date());
			vendorProductsEntity.setProductPrice(vendorProductsDTO.getPrice());
			vendorProductsEntity.setProductQty(vendorProductsDTO.getQuantity());
			vendorProductsEntity.setVendorTransactionId(vendorTransactionId);
			session.save(vendorProductsEntity);
		}

		//Saving vendor wise deductions
		List<VendorDeductionsDTO> vendorDeductionsDTOs = postVendorBillDTO.getDeductions();
		for (VendorDeductionsDTO vendorDeductionsDTO : vendorDeductionsDTOs) {
			VendorDeductionsEntity vendorDeductionsEntity =new VendorDeductionsEntity();
			vendorDeductionsEntity.setCreatedAt(new Date());
			vendorDeductionsEntity.setDeductionTypeId(vendorDeductionsDTO.getDeductiontypeid());
			vendorDeductionsEntity.setDeductionValue(vendorDeductionsDTO.getDeductionvalue());
			vendorDeductionsEntity.setVendorTransactionId(vendorTransactionId);
			session.save(vendorDeductionsEntity);
		}
	}

	private int getVendorId(int providerid, String mobileNumber) {
		return (Integer) _sessionFactory.getCurrentSession().createCriteria(VendorsEntity.class)
				.add(Restrictions.eq(Constants.PROVIDER_ID, providerid))
				.add(Restrictions.eq(Constants.MOBILE_NUMBER, mobileNumber))
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.VENDOR_ID).as(Constants.VENDOR_ID)))
				.uniqueResult();
	}
	

}
