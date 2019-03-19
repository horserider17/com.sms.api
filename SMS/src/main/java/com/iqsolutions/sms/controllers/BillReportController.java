package com.iqsolutions.sms.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.iqsolutions.sms.services.BillReportService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * This controller is for vendor transactions
 * @author tdk
 *
 */
@Controller
@RequestMapping(value="api/pdf")
@CrossOrigin(origins="*")
public class BillReportController extends SmsBaseController {

	private static final Logger logger = LoggerFactory.getLogger(BillReportController.class);

	@Autowired
	private BillReportService _billReportService;

	@Autowired
	private ApplicationContext appContext;

	/**
	 * This is to send the data of master deductions and previous vendors bills
	 * @return
	 */
	@GetMapping()
	public ModelAndView getBillReport(@RequestParam int providerid,
			@RequestParam int vendortransactionid) {
		logger.info("Bill Report :");
		try {
			JasperReportsPdfView view = new JasperReportsPdfView();
			
			view.setUrl("classpath:bill_report.jrxml");
			view.setApplicationContext(appContext);
			
			Map<String, Object> jsonObject = _billReportService.getBillReport(providerid, vendortransactionid);
			List<Map<String, Object>> jsonObjects = new ArrayList<>();
			jsonObjects.add(jsonObject);
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(jsonObjects);

			Map<String, Object> params = new HashMap<String, Object>();

			params.put("datasource", jrDataSource);
			String subReportPath1 = this.getClass().getClassLoader()
					.getResource("bill-report-products-subreport.jrxml").getFile().substring(1);
			String subReportPath2 = this.getClass().getClassLoader()
					.getResource("bill-report-deductions-subreport.jrxml").getFile().substring(1);

			params.put("subReportPath1", java.io.File.separator + subReportPath1.replaceAll("%20", " "));
			params.put("subReportPath2", java.io.File.separator + subReportPath2.replaceAll("%20", " "));
			params.put("fileName", "bill_report");
			params.put("btnType", 1);
			return new ModelAndView(view, params);


			//			MBRecordingListMeasurementsDTO mbRecordingListMeasurementsDTO = reportsService
			//					.listOfBoqMeasurementsPDF(mbReferenceNumber);
			//			List<MBRecordingListMeasurementsDTO> mbRecordingListMeasurementsDTOs = new ArrayList<>();
			//			mbRecordingListMeasurementsDTOs.add(mbRecordingListMeasurementsDTO);
			//			JRDataSource jrDataSource = new JRBeanCollectionDataSource(mbRecordingListMeasurementsDTOs);
			//			Map<String, Object> parameterMap = new HashMap<>();
			//
			//			String subReportPath1 = this.getClass().getClassLoader()
			//					.getResource("reports/mb-boq-measuremnets-deviations-subreport.jrxml").getFile().substring(1);
			//			String subReportPath2 = this.getClass().getClassLoader()
			//					.getResource("reports/mb-boq-measurements-subreport.jrxml").getFile().substring(1);
			//
			//			String subReportPath3 = this.getClass().getClassLoader()
			//					.getResource("reports/mb-boq-deviations-subreport.jrxml").getFile().substring(1);
			//
			//			String subReportPath4 = this.getClass().getClassLoader().getResource("reports/mb-boq-images.jrxml")
			//					.getFile().substring(1);
			//			parameterMap.put("datasource", jrDataSource);
			//			parameterMap.put("btnType", btnType);
			//			parameterMap.put("imagesPath", imagesPath);
			//			parameterMap.put("subReportPath1", java.io.File.separator + subReportPath1.replaceAll("%20", " "));
			//			parameterMap.put("subReportPath2", java.io.File.separator + subReportPath2.replaceAll("%20", " "));
			//			parameterMap.put("subReportPath3", java.io.File.separator + subReportPath3.replaceAll("%20", " "));
			//			parameterMap.put("subReportPath4", java.io.File.separator + subReportPath4.replaceAll("%20", " "));
			//			parameterMap.put("fileName", "MBRecordings");
			//			addWorksLabel(parameterMap);
			//			return new ModelAndView("mb-all-boqs-report", parameterMap);
		} catch (Exception e) {
			logger.error(String.format("%s %s","Error in List BOQMeasurements view PDF" , ExceptionUtils.getFullStackTrace(e)));
			return new ModelAndView("Error in bill report :");
		}
	}

}
