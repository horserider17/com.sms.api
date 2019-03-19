/**
 * 
 */
package com.iqsolutions.sms.services;

import java.util.Map;

public interface BillReportService {

	Map<String, Object> getBillReport(int providerId, int transactionId);


}
