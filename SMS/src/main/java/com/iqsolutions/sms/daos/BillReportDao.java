package com.iqsolutions.sms.daos;

import java.util.List;
import java.util.Map;

public interface BillReportDao {
	
	Map<String, Object> getProviderDetails(int providerId);

	Map<String, Object> getBillTransactionDetails(int transactionId);

	List<Map<String, Object>> getAllProductDetails(int transactionId);

	List<Map<String, Object>> getAllBillDeductions(int transactionId);

	void updateBillGenerated(int transactionId);

}
