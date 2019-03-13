package com.iqsolutions.sms.daos;

import java.util.List;
import java.util.Map;

public interface MasterDeductionsDao {
	
	List<Map<String, Object>> getAllMasterDedctions(int providerId);

}
