package com.iqsolutions.sms.daos;

import com.iqsolutions.sms.entities.ProviderEntity;

public interface LoginDao {
	

	public ProviderEntity checkLogin(ProviderEntity ProviderEntity);

}
