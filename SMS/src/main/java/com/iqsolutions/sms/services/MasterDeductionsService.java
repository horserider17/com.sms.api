/**
 * 
 */
package com.iqsolutions.sms.services;

import java.util.List;

import com.iqsolutions.sms.dtos.MasterDeductionsDTO;

public interface MasterDeductionsService {

	List<MasterDeductionsDTO> getAllMasterDedctions(int providerId);


}
