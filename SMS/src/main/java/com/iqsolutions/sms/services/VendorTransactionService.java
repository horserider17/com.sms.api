/**
 * 
 */
package com.iqsolutions.sms.services;

import com.iqsolutions.sms.dtos.GetVendorBillDTO;
import com.iqsolutions.sms.dtos.PostVendorBillDTO;

public interface VendorTransactionService {

	GetVendorBillDTO getDataForAddBill(int providerId);

	void saveVendorTransaction(PostVendorBillDTO postVendorBillDTO);

}
