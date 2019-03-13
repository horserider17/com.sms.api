package com.iqsolutions.sms.daos;

import java.util.List;
import java.util.Map;

import com.iqsolutions.sms.dtos.PostVendorBillDTO;

public interface VendorTransactionDao {

	List<Map<String, Object>> getMasterDedctions(int providerId);

	List<Map<String, Object>> getAllBills(int providerId);

	void saveVendorTransaction(PostVendorBillDTO postVendorBillDTO);

}
