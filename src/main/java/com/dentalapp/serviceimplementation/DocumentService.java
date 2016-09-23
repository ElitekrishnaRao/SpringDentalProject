package com.dentalapp.serviceimplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dentalapp.dao.beans.PatientDetails;
import com.dentalapp.doc.utility.DocumentUtility;
import com.dentalapp.services.DocumentOperations;
import com.dentalapp.services.SearchDAO;

@Component
public class DocumentService implements DocumentOperations {
	@Autowired
	private SearchDAO searchDAO;


	public FileInputStream createWordDoument(Map<String, String[]> requestValues) {
		PatientDetails patientDetails = searchDAO.saveInsuranceDetails(requestValues);
		XWPFDocument document= new XWPFDocument(); 
		//Write the Document in file system
		FileOutputStream out;
		FileInputStream in;
		try {
			out = new FileOutputStream(
					new File("InsuranceDetails.docx"));
			//create header
			document = DocumentUtility.createHeader(document);
			//create Paragraph
			document = DocumentUtility.createParagraph(document);
			// Add a break between the tables
			document.createParagraph().createRun().addBreak();
			//create Table
			document = DocumentUtility.createTable(document,patientDetails);
			document.write(out);
			out.close();
			in = new FileInputStream("InsuranceDetails.docx");
			return in;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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

}
