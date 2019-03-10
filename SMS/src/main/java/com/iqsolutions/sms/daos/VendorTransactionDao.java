package com.iqsolutions.sms.daos;

import java.util.List;

import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.entities.VendorTransactionsEntity;

public interface VendorTransactionDao {
	
	List<ProviderEntity> getVendorTransactions();

	void saveVendorTransaction(VendorTransactionsEntity vendorTransactionsEntity);

}
