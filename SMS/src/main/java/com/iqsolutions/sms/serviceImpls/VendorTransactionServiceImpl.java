/**
 * 
 */
package com.iqsolutions.sms.serviceImpls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqsolutions.sms.daos.VendorTransactionDao;
import com.iqsolutions.sms.dtos.GetVendorBillDTO;
import com.iqsolutions.sms.dtos.MasterDeductionsDTO;
import com.iqsolutions.sms.dtos.PostVendorBillDTO;
import com.iqsolutions.sms.dtos.VendorBillsDTO;
import com.iqsolutions.sms.services.VendorTransactionService;
import com.iqsolutions.sms.utils.Constants;

@Service
public class VendorTransactionServiceImpl implements VendorTransactionService {
	
	@Autowired
	private VendorTransactionDao _vendorTransactionDao;

	@Override
	@Transactional
	public GetVendorBillDTO getDataForAddBill(int providerId) {
		GetVendorBillDTO getVendorBillDTO = new GetVendorBillDTO();
//		getVendorBillDTO.setHamalicost(_vendorTransactionDao.getHamaliCost(providerId));
		
		// Fetching Master deductions except hamali
		List<MasterDeductionsDTO> masterDeductionsDTOs = new ArrayList<MasterDeductionsDTO>();
		List<Map<String, Object>> masterDeductionsEntities = _vendorTransactionDao.getMasterDedctions(providerId);
		System.out.println(masterDeductionsEntities);
		for (Map<String, Object> map : masterDeductionsEntities) {
			MasterDeductionsDTO masterDeductionsDTO = new MasterDeductionsDTO();
			masterDeductionsDTO.setDeductiontype((String) map.get(Constants.DEDUCTION_TYPE));
			masterDeductionsDTO.setDeductionvalue((Double) map.get(Constants.DEDUCTION_VALUE));
			masterDeductionsDTO.setDeductiontypeid((Integer) map.get(Constants.DEDUCTION_TYPE_ID));
			masterDeductionsDTOs.add(masterDeductionsDTO);
		}
		getVendorBillDTO.setDeductions(masterDeductionsDTOs);
		
		// Fetching all previous bills
		List<VendorBillsDTO> vendorBillsDTOs = new ArrayList<VendorBillsDTO>();
		List<Map<String, Object>> allBills = _vendorTransactionDao.getAllBills(providerId);
		for (Map<String, Object> map : allBills) {
			VendorBillsDTO vendorBillsDTO = new VendorBillsDTO();
			vendorBillsDTO.setVendorname((String) map.get(Constants.VENDOR_NAME));
			vendorBillsDTO.setMobilenumber((String) map.get(Constants.MOBILE_NUMBER));
			vendorBillsDTO.setTotalamount((Double) map.get(Constants.TOTAL_AMOUNT));
			vendorBillsDTO.setIsbillgenerated((Boolean) map.get(Constants.IS_BILL_GENERATOR));
			vendorBillsDTO.setTransactiondate((Date) map.get(Constants.TRANSACTION_DATE));
			vendorBillsDTO.setVendortransactionid((Integer) map.get(Constants.VENODR_TRANSACTION_ID));
			vendorBillsDTOs.add(vendorBillsDTO);
		}
		getVendorBillDTO.setVendorbills(vendorBillsDTOs);
		return getVendorBillDTO;
	}

	@Override
	@Transactional
	public void saveVendorTransaction(PostVendorBillDTO postVendorBillDTO) {
		 _vendorTransactionDao.saveVendorTransaction(postVendorBillDTO);
	}

}
