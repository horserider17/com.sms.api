/**
 * 
 */
package com.iqsolutions.sms.serviceImpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqsolutions.sms.daos.MasterDeductionsDao;
import com.iqsolutions.sms.dtos.MasterDeductionsDTO;
import com.iqsolutions.sms.services.MasterDeductionsService;
import com.iqsolutions.sms.utils.Constants;

@Service
public class MasterDeductionsServiceImpl implements MasterDeductionsService {

	@Autowired
	private MasterDeductionsDao _masterDeductionsDao;
	
	@Override
	@Transactional
	public List<MasterDeductionsDTO> getAllMasterDedctions(int providerId) {
		List<Map<String, Object>> masterDeductionsEntities = _masterDeductionsDao.getAllMasterDedctions(providerId);
		List<MasterDeductionsDTO> masterDeductionsDTOs = new ArrayList<MasterDeductionsDTO>();
		for (Map<String, Object> masterDeductionsEntity : masterDeductionsEntities) {
			MasterDeductionsDTO masterDeductionsDTO = new MasterDeductionsDTO();
			masterDeductionsDTO.setDeductiontype((String) masterDeductionsEntity.get(Constants.DEDUCTION_TYPE));
			masterDeductionsDTO.setDeductionid((Integer) masterDeductionsEntity.get(Constants.DEDUCTION_TYPE));
			masterDeductionsDTO.setDeductionvalue((Double) masterDeductionsEntity.get(Constants.DEDUCTION_VALUE));
			masterDeductionsDTO.setIsactive((Boolean) masterDeductionsEntity.get(Constants.IS_ACTIVE));
			masterDeductionsDTOs.add(masterDeductionsDTO);
		}
		return masterDeductionsDTOs;
	}

	
	
}
