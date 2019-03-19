package com.iqsolutions.sms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iqsolutions.sms.dtos.ProviderDTO;
import com.iqsolutions.sms.services.ProviderService;
import com.iqsolutions.sms.utils.Constants;
import com.iqsolutions.sms.utils.WebResponseEntity;

/**
 * This controller is for vendor transactions
 * @author tdk
 *
 *
 */
@Controller
@RequestMapping(value="api/provider")
@CrossOrigin(origins="*")
public class ProviderController extends SmsBaseController {

	private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

	@Autowired
	private ProviderService _providerService;

	/**
	 * This is to get the provider details
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping()
	public ResponseEntity<WebResponseEntity> getProviderDetails(@RequestParam int providerId) {
		try {
			return BuildResponse(Constants.MESSAGES_SUCCESS, _providerService.getProviderDetails(providerId));
		} catch (Exception e) {
			return BuildErrorResponse(e);
		}
	}
	
	/**
	 * This is to save the provider details
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping()
	public ResponseEntity<WebResponseEntity> saveProviderDetails(@RequestBody ProviderDTO providerDTO) {
		try {
			 _providerService.saveProviderDetails(providerDTO);
			return BuildResponse(Constants.MESSAGES_CREATED);
		} catch (Exception e) {
			return BuildErrorResponse(e);
		}
	}
}
