package com.iqsolutions.sms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iqsolutions.sms.services.MasterDeductionsService;
import com.iqsolutions.sms.utils.Constants;
import com.iqsolutions.sms.utils.WebResponseEntity;

/**
 * This controller is for vendor transactions
 * @author tdk
 *
 */
@Controller
@RequestMapping(value="api/master-deductions")
public class MasterDeductionsController extends SmsBaseController {

	private static final Logger logger = LoggerFactory.getLogger(MasterDeductionsController.class);

	@Autowired
	private MasterDeductionsService _masterDeductionsService;

	/**
	 * This is to send the data of master deductions and previous vendors bills
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value="/byid")
	public ResponseEntity<WebResponseEntity> getAllMasterDedctions(@RequestParam int providerId) {
		try {
			return BuildResponse(Constants.MESSAGES_SUCCESS, _masterDeductionsService.getAllMasterDedctions(providerId));
		} catch (Exception e) {
			return BuildErrorResponse(e);
		}

	}

}
