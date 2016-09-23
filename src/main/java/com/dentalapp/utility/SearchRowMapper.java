package com.dentalapp.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dentalapp.dao.beans.PatientDetails;

public class SearchRowMapper implements RowMapper<Object> {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setPatientName(rs.getString("patientName"));
		patientDetails.setInsuranceCompany(rs.getString("insuranceCompany"));
		patientDetails.setPayerID(rs.getString("payerID"));
		patientDetails.setFileMedicalFirst(rs.getString("fileMedicalFirst"));
		patientDetails.setEffectiveDate(rs.getString("effectiveDate"));
		patientDetails.setRunsOn(rs.getString("runsOn"));
		patientDetails.setTypeOfCoverage(rs.getString("typeOfCoverage"));
		patientDetails.setInOrOutNetwork(rs.getString("inOrOutNetwork"));
		patientDetails.setPlan(rs.getString("plan"));
		patientDetails.setCoordination(rs.getString("coordination"));
		patientDetails.setPlanFollows(rs.getString("planFollows"));
		
		return patientDetails;
	}

}
