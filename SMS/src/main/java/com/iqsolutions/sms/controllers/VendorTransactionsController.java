package com.iqsolutions.sms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iqsolutions.sms.dtos.PostVendorBillDTO;
import com.iqsolutions.sms.services.VendorTransactionService;
import com.iqsolutions.sms.utils.Constants;
import com.iqsolutions.sms.utils.WebResponseEntity;

/**
 * This controller is for vendor transactions
 * @author tdk
 *
 */
@Controller
@RequestMapping(value="api/vendor-transactions")
public class VendorTransactionsController extends SmsBaseController {

	private static final Logger logger = LoggerFactory.getLogger(VendorTransactionsController.class);

	@Autowired
	private VendorTransactionService _vendorTransactionService;

	/**
	 * This is to send the data of master deductions and previous vendors bills
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value="/byid")
	public ResponseEntity<WebResponseEntity> getDataForAddBill(@RequestParam int providerId) {
		try {
			return BuildResponse(Constants.MESSAGES_SUCCESS, _vendorTransactionService.getDataForAddBill(providerId));
		} catch (Exception e) {
			return BuildErrorResponse(e);
		}

	}

	/**
	 * This method is for saving vendor transactions
	 * @param vendorTransactionsEntity
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping()
	public ResponseEntity<WebResponseEntity> saveVendorTransaction(
			@RequestBody PostVendorBillDTO postVendorBillDTO){
		logger.info("Saving Vendor Transaction :");
		try {
			_vendorTransactionService.saveVendorTransaction(postVendorBillDTO);
			return BuildResponse(Constants.MESSAGES_CREATED);
		}catch(Exception e){
			logger.info("Error in Saving Vendor Transaction :");
			return BuildErrorResponse(e);
		}
	}
}
