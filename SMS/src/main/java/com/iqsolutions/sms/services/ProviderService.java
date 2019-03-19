/**
 * 
 */
package com.iqsolutions.sms.services;

import com.iqsolutions.sms.dtos.ProviderDTO;

public interface ProviderService {

	ProviderDTO getProviderDetails(int providerId);

	void saveProviderDetails(ProviderDTO providerDTO);



}
