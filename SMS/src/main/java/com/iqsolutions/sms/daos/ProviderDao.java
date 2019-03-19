package com.iqsolutions.sms.daos;

import java.util.Map;

import com.iqsolutions.sms.dtos.ProviderDTO;

public interface ProviderDao {

	Map<String, Object> getProviderDetails(int providerId);

	void saveProviderDetails(ProviderDTO providerDTO);
	

}
