/**
 * 
 */
package com.iqsolutions.sms.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqsolutions.sms.daos.VendorTransactionDao;
import com.iqsolutions.sms.entities.ProviderEntity;
import com.iqsolutions.sms.entities.VendorTransactionsEntity;
import com.iqsolutions.sms.services.VendorTransactionService;

@Service
public class VendorTransactionServiceImpl implements VendorTransactionService {
	
	@Autowired
	private VendorTransactionDao _vendorTransactionDao;

	@Transactional
	public List<ProviderEntity> getVendorTransactions() {
		return _vendorTransactionDao.getVendorTransactions();
	}

	@Override
	@Transactional
	public void saveVendorTransaction(VendorTransactionsEntity vendorTransactionsEntity) {
		 _vendorTransactionDao.saveVendorTransaction(vendorTransactionsEntity);
	}

}
