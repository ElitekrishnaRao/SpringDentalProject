package com.dentalapp.services;

import java.util.Map;

import com.dentalapp.dao.beans.PatientDetails;

public interface SearchDAO {
	
	public PatientDetails searchPatientDetails(String patientName,String insuranceCompany);
	
	public PatientDetails saveInsuranceDetails(Map<String, String[]> requestValues );	

}
