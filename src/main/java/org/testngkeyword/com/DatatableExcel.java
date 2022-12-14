package org.testngkeyword.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatatableExcel {

	String path;

	Workbook workbook;

	org.apache.poi.ss.usermodel.Sheet sheet;

	Row row;

	public DatatableExcel(String excelpath)
	{
		this.path=excelpath;
	}

	public void createconnection() throws Exception
	{

		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);	
		workbook=WorkbookFactory.create(fis);
		sheet = workbook.getSheetAt(0);		
		int noofrows=sheet.getLastRowNum();
		System.out.println(noofrows);
	}

	public List<String> getAllMethods()
	{

		List<String> op= new ArrayList<String>();

		int rownum=0;

		
			for (int j=1;j<sheet.getRow(rownum).getPhysicalNumberOfCells();j++)
			{	
				op.add(sheet.getRow(rownum).getCell(j).getStringCellValue());

			}	
		


		return op;
	}


}
