package com.dentalapp.serviceimplementation;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dentalapp.dao.beans.PatientDetails;
import com.dentalapp.services.SearchDAO;
import com.dentalapp.utility.SearchRowMapper;

@Component
public class SearchService implements SearchDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public PatientDetails searchPatientDetails(String patientName, String insuranceCompany) {
		String SQL = "select *from patientdetails where patientName = ? and insuranceCompany = ?";  
		System.out.println(patientName);
		System.out.println(insuranceCompany);
		System.out.println(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println(jdbcTemplate);
		try{
			PatientDetails patientDetails = (PatientDetails)jdbcTemplate.queryForObject(
					SQL, new Object[] {patientName,insuranceCompany}, new SearchRowMapper());
			if(patientDetails!=null){
				return patientDetails;
			}
		}
		catch(EmptyResultDataAccessException exc){
			exc.printStackTrace();
			return new PatientDetails();
		}

		return new PatientDetails();
	}

	public PatientDetails saveInsuranceDetails(Map<String, String[]> requestValues ) {
		String SQL = "update patientdetails set payerID=?,fileMedicalFirst=?,effectiveDate=?,runsOn=?,typeOfCoverage=?,inOrOutNetwork=?,plan=?,coordination=?,planFollows=? where patientName = ? and insuranceCompany = ?";
		System.out.println(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		 int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				 Types.VARCHAR, Types.VARCHAR};
		System.out.println(jdbcTemplate);
		try{
			int rows =jdbcTemplate.update(
					SQL, new Object[] {requestValues.get("payerID")[0] ,requestValues.get("fileMedicalFirst")[0], requestValues.get("effectiveDate")[0] ,requestValues.get("runsOn")[0],requestValues.get("typeOfCoverage")[0] ,requestValues.get("inOrOutNetwork")[0] ,requestValues.get("plan")[0] ,requestValues.get("coordination")[0], requestValues.get("planFollows")[0],requestValues.get("patientName")[0],requestValues.get("insuranceCompany")[0]}, types);
			if(rows>0){
				return searchPatientDetails(requestValues.get("patientName")[0],requestValues.get("insuranceCompany")[0]);
			}
		}
		catch(EmptyResultDataAccessException exc){
			exc.printStackTrace();
			return new PatientDetails();
		}

		return new PatientDetails();
	}
	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("Autowire SearchService:-"+jdbcTemplate);
	}
	
	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
