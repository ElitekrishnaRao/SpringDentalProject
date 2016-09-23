package com.dentalapp.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dentalapp.dao.beans.PatientDetails;
import com.dentalapp.services.DocumentOperations;
import com.dentalapp.services.SearchDAO;

@Controller
public class SearchController {

	@Autowired
	private SearchDAO searchDAO;

	@Autowired
	DocumentOperations documentOperations;

	@RequestMapping(value = "/searchPatient", method = RequestMethod.POST)
	public String searhInsurance(ModelMap model,@RequestParam String patientName,@RequestParam String insuranceCompany) {	
		PatientDetails patientDetails = searchDAO.searchPatientDetails(patientName, insuranceCompany);		
		model.addAttribute("patientDetails", patientDetails);
		return "contact";

	}

	@RequestMapping(value = "/saveInsuranceDetails", method = RequestMethod.POST)
	public String saveInsuranceDetails(ModelMap model,HttpServletRequest request) {	
		Map<String, String[]> requestValues = request.getParameterMap();
		PatientDetails patientDetails = searchDAO.saveInsuranceDetails(requestValues);		
		model.addAttribute("patientDetails", patientDetails);
		return "contact";
	}

	@RequestMapping("/exportDocument")
	public void downloadInsuranceDetails( HttpServletRequest request, 
			HttpServletResponse response) 
	{
		Map<String, String[]> requestValues = request.getParameterMap();
		response.setContentType("application/msword");
		response.addHeader("Content-Disposition", "attachment; fileName=\"InsuranceDocument.docx\"");
		try
		{
			FileInputStream fis = documentOperations.createWordDoument(requestValues);
			IOUtils.copy(fis, response.getOutputStream());
			response.getOutputStream().flush();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @return the searchDAO
	 */
	public SearchDAO getSearchDAO() {
		return searchDAO;
	}

	/**
	 * @param searchDAO the searchDAO to set
	 */
	public void setSearchDAO(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}

	/**
	 * @return the documentOperations
	 */
	public DocumentOperations getDocumentOperations() {
		return documentOperations;
	}

	/**
	 * @param documentOperations the documentOperations to set
	 */
	public void setDocumentOperations(DocumentOperations documentOperations) {
		this.documentOperations = documentOperations;
	}
}
