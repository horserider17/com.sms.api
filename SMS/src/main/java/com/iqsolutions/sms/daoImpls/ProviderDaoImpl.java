package com.iqsolutions.sms.daoImpls;

import java.util.Date;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqsolutions.sms.daos.ProviderDao;
import com.iqsolutions.sms.dtos.ProviderDTO;
import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.utils.Constants;

@Component
public class ProviderDaoImpl implements ProviderDao {

	@Autowired
	private SessionFactory _sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getProviderDetails(int providerId) {
		return (Map<String, Object>) _sessionFactory.getCurrentSession().createCriteria(ProviderEntity.class)
				.add(Restrictions.eq(Constants.PROVIDER_ID, providerId))
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.PROVIDER_ID).as(Constants.PROVIDER_ID))
						.add(Projections.property(Constants.FIRST_NAME).as(Constants.FIRST_NAME))
						.add(Projections.property(Constants.LAST_NAME).as(Constants.LAST_NAME))
						.add(Projections.property(Constants.EMAIL).as(Constants.EMAIL))
						.add(Projections.property(Constants.MOBILE_NUMBER).as(Constants.MOBILE_NUMBER))
						.add(Projections.property(Constants.COMPANY_NAME).as(Constants.COMPANY_NAME))
						.add(Projections.property(Constants.LICENSE).as(Constants.LICENSE))
						.add(Projections.property(Constants.SHOP_NAME).as(Constants.SHOP_NAME))
						.add(Projections.property(Constants.ADDRESS).as(Constants.ADDRESS))
						.add(Projections.property(Constants.CAPTION).as(Constants.CAPTION)))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).uniqueResult();
	}

	@Override
	public void saveProviderDetails(ProviderDTO providerDTO) {
		Session session= _sessionFactory.getCurrentSession();
		ProviderEntity providerEntity = (ProviderEntity) session.createCriteria(ProviderEntity.class)
				.add(Restrictions.eq(Constants.PROVIDER_ID, providerDTO.getProviderid())).uniqueResult();
		providerEntity.setActive(true);
		providerEntity.setAddress(providerDTO.getAddress());
		providerEntity.setCaption(providerDTO.getCaption());
		providerEntity.setCompanyName(providerDTO.getCompanyname());
		providerEntity.setCreatedAt(new Date());
		providerEntity.setEmail(providerDTO.getEmail());
		providerEntity.setFirstName(providerDTO.getFirstname());
		providerEntity.setLastName(providerDTO.getLastname());
		providerEntity.setLicense(providerDTO.getLicense());
		providerEntity.setMobileNumber(providerDTO.getMobilenumber());
		providerEntity.setShopNo(providerDTO.getShopno());
		session.update(providerEntity);
		
	}

	
	
}
