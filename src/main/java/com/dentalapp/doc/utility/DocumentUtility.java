package com.dentalapp.doc.utility;

import java.io.IOException;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

import com.dentalapp.dao.beans.PatientDetails;

public class DocumentUtility {

	public static XWPFDocument createHeader(XWPFDocument docx){		
		CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
		XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx, sectPr);

		//write header content
		CTP ctpHeader = CTP.Factory.newInstance();
		CTR ctrHeader = ctpHeader.addNewR();
		CTText ctHeader = ctrHeader.addNewT();
		String headerText = "INSURANCE VERIFICATION FORM";
		ctHeader.setStringValue(headerText);	
		XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, docx);
		headerParagraph.setAlignment(ParagraphAlignment.CENTER);
		XWPFParagraph[] parsHeader = new XWPFParagraph[1];
		parsHeader[0] = headerParagraph;
		try {
			policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return docx; 
	}

	public static XWPFDocument createParagraph(XWPFDocument docx){	
		XWPFParagraph paragraph = docx.createParagraph();
		XWPFRun run=paragraph.createRun();
		run.setText("URGENT NOTES(Plan not active)");
		run.setColor("FF0000");
		run.setBold(true);
		return docx; 
	}

	public static XWPFDocument createTable(XWPFDocument doc, PatientDetails patientDetails) throws Exception {
		 // New 3x3 table
		//create table
		   XWPFTable table = doc.createTable();
		   table.setStyleID("finest");
		   CTTblPr tblpro = table.getCTTbl().getTblPr();

		   CTTblBorders borders = tblpro.addNewTblBorders();
		   borders.addNewBottom().setVal(STBorder.SINGLE); 
		   borders.addNewLeft().setVal(STBorder.SINGLE);
		   borders.addNewRight().setVal(STBorder.SINGLE);
		   borders.addNewTop().setVal(STBorder.SINGLE);
		   //also inner borders
		   borders.addNewInsideH().setVal(STBorder.SINGLE);
		   borders.addNewInsideV().setVal(STBorder.SINGLE);
		   
		   //create first row
		   XWPFTableRow tableRowOne = table.getRow(0);
		   tableRowOne.getCell(0).setText("Patient name");
		   tableRowOne.addNewTableCell().setText("Insurance Company Name");
		   tableRowOne.addNewTableCell().setText("Type Of Coverage");
		   //create second row
		   XWPFTableRow tableRowTwo = table.createRow();
		   tableRowTwo.getCell(0).setText(patientDetails.getPatientName());
		   tableRowTwo.getCell(1).setText(patientDetails.getInsuranceCompany());
		   tableRowTwo.getCell(2).setText(patientDetails.getTypeOfCoverage());
	    
		   table.setWidth(100);
		   table.setColBandSize(50);
		   table.setRowBandSize(50);
	    
		return doc;
		
		
	}

}
