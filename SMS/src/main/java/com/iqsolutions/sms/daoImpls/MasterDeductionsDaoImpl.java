package com.iqsolutions.sms.daoImpls;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqsolutions.sms.daos.MasterDeductionsDao;
import com.iqsolutions.sms.entities.MasterDeductionsEntity;
import com.iqsolutions.sms.utils.Constants;

@Component
public class MasterDeductionsDaoImpl implements MasterDeductionsDao {

	@Autowired
	private SessionFactory _sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllMasterDedctions(int providerId) {
		return _sessionFactory.getCurrentSession().createCriteria(MasterDeductionsEntity.class)
				.add(Restrictions.eq(Constants.PROVIDER_ID, Constants.PROVIDER_ID))
				.createAlias(Constants.MASTER_DEDUCTION_TYPE_ENTITY, Constants.MASTER_DEDUCTION_TYPE_ENTITY, JoinType.LEFT_OUTER_JOIN)
				.setProjection(Projections.projectionList()
						.add(Projections.property(Constants.MASTER_DEDUCTION_TYPE_ENTITY_DEDUCTION_TYPE)
								.as(Constants.MASTER_DEDUCTION_TYPE_ENTITY_DEDUCTION_TYPE))
						.add(Projections.property(Constants.DEDUCTION_ID).as(Constants.DEDUCTION_ID))
						.add(Projections.property(Constants.DEDUCTION_VALUE).as(Constants.DEDUCTION_VALUE))
						.add(Projections.property(Constants.IS_ACTIVE).as(Constants.IS_ACTIVE)))
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
	}
	

}
