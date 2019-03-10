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

import com.iqsolutions.sms.entities.VendorTransactionsEntity;
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
	 * This method is for saving vendor transactions
	 * @param vendorTransactionsEntity
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping()
	public ResponseEntity<WebResponseEntity> saveVendorTransaction(
			@RequestBody VendorTransactionsEntity vendorTransactionsEntity){
		logger.info("Saving Vendor Transaction :");
		try {
			_vendorTransactionService.saveVendorTransaction(vendorTransactionsEntity);
			return BuildResponse(Constants.MESSAGES_CREATED);
		}catch(Exception exception){
			logger.info("Error in Saving Vendor Transaction :");
			return BuildErrorResponse();
		}
	}

	/**
	 * This method is for getting all vendors transactions
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping()
	public ResponseEntity<WebResponseEntity> getVendorTransactions() {
		try {
			return BuildResponse(Constants.MESSAGES_SUCCESS, _vendorTransactionService.getVendorTransactions());
		} catch (Exception e) {
			return BuildErrorResponse();
		}

	}

}
