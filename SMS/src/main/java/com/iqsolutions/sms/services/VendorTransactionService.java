/**
 * 
 */
package com.iqsolutions.sms.services;

import java.util.List;

import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.entities.VendorTransactionsEntity;

public interface VendorTransactionService {

	List<ProviderEntity> getVendorTransactions();

	void saveVendorTransaction(VendorTransactionsEntity vendorTransactionsEntity);

}
