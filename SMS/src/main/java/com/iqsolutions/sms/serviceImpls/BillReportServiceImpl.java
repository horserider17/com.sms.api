/**
 * 
 */
package com.iqsolutions.sms.serviceImpls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqsolutions.sms.daos.BillReportDao;
import com.iqsolutions.sms.services.BillReportService;
import com.iqsolutions.sms.utils.Constants;

@Service
public class BillReportServiceImpl implements BillReportService {

	@Autowired
	private BillReportDao _billReportDao;

	@Override
	@Transactional
	public Map<String, Object> getBillReport(int providerId, int transactionId) {
		Map<String, Object> finalResponse = new HashMap<String, Object>();

		// Get provider details
		finalResponse.putAll(_billReportDao.getProviderDetails(providerId));

		// Get bill transaction details
		finalResponse.putAll(_billReportDao.getBillTransactionDetails(transactionId));

		// Get all products qty and amount
		List<Map<String, Object>> products = _billReportDao.getAllProductDetails(transactionId);
		finalResponse.put("products", products);

		// Get sum of all products
		double sumOfProducts = 0;
		for (Map<String, Object> product : products) {
			sumOfProducts = sumOfProducts + (Double) product.get("productAmount");
		}
		finalResponse.put("sumOfProducts", sumOfProducts);

		double sumOfQty = 0;
		for (Map<String, Object> product : products) {
			sumOfQty = sumOfQty + (Double) product.get(Constants.PRODUCT_QTY);
		}
		finalResponse.put("sumOfQty", sumOfQty);

		// Get all products qty and amount
		List<Map<String, Object>> deductions = _billReportDao.getAllBillDeductions(transactionId);
		for (Map<String, Object> map : deductions) {
			if((Integer) map.get(Constants.DEDUCTION_TYPE_ID)==1) {
				map.put("deductionAmount", (Double) map.get(Constants.DEDUCTION_VALUE) * sumOfQty);
			}else {
				map.put("deductionAmount", ((Double) map.get(Constants.DEDUCTION_VALUE) * sumOfProducts)/100);
			}
		}
		
		// Adding Advance to deductions
		Map<String, Object> advance = new HashMap<String, Object>();
		advance.put("deductionType", "advance");
		advance.put("deductionValue", null);
		advance.put("deductionAmount", finalResponse.get(Constants.ADVANCE));
		deductions.add(advance);
		finalResponse.put("deductions", deductions);

		// Get sum of all deductions
		double sumOfDeductions = 0;
		for (Map<String, Object> deduction : deductions) {
			sumOfDeductions = sumOfDeductions + (Double) deduction.get("deductionAmount");
		}
		finalResponse.put("sumOfDeductions", sumOfDeductions);
		System.out.println("finalResponse :"+finalResponse);
		
		//update isBillGenerated flag
		_billReportDao.updateBillGenerated(transactionId);
		return finalResponse;
	}
	
	
}
