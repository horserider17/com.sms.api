/**
 * 
 */
package com.iqsolutions.sms.serviceImpls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqsolutions.sms.daos.ProviderDao;
import com.iqsolutions.sms.dtos.ProviderDTO;
import com.iqsolutions.sms.services.ProviderService;
import com.iqsolutions.sms.utils.Constants;

@Service
public class ProviderServiceImpl implements ProviderService {
	
	@Autowired
	private ProviderDao _providerDao;

	@Override
	@Transactional
	public ProviderDTO getProviderDetails(int providerId) { 
		Map<String, Object> providerDetails = _providerDao.getProviderDetails(providerId);
		ProviderDTO providerDTO = new ProviderDTO();
		providerDTO.setProviderid((int) providerDetails.get(Constants.PROVIDER_ID));
		providerDTO.setFirstname((String) providerDetails.get(Constants.FIRST_NAME));
		providerDTO.setLastname((String) providerDetails.get(Constants.LAST_NAME));
		providerDTO.setEmail((String) providerDetails.get(Constants.EMAIL));
		providerDTO.setShopno((String) providerDetails.get(Constants.SHOP_NAME));
		providerDTO.setCompanyname((String) providerDetails.get(Constants.COMPANY_NAME));
		providerDTO.setLicense((String) providerDetails.get(Constants.LICENSE));
		providerDTO.setMobilenumber((String) providerDetails.get(Constants.MOBILE_NUMBER));
		providerDTO.setCaption((String) providerDetails.get(Constants.CAPTION));
		providerDTO.setAddress((String) providerDetails.get(Constants.ADDRESS));
		return providerDTO;
	}

	@Override
	@Transactional
	public void saveProviderDetails(ProviderDTO providerDTO) {
		_providerDao.saveProviderDetails(providerDTO);	
	}
	
}
