package com.hybrid.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import okio.ByteString;

public class ExcelDataProviders {

	XSSFWorkbook wb;

	public ExcelDataProviders() {
		File src = new File("./Testdata/Testdata.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Test data File not found" + e.getMessage());

		}
		
	}
	
	public String getStringData(String sheet, int row,int col) {
		return wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public Double getNumericData(String sheet, int row,int col) {
		return wb.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
		
	}
	
	public String getStringData(int sheetIndex, int row,int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		
	}

}
