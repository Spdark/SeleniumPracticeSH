package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils{
	 XSSFSheet excelSheet;
	XSSFWorkbook excel;
	
	public Utils() {
		try{
			FileInputStream fileStream = new FileInputStream("src/test/java/TestData/loginData.xlsx");
			 excel = new XSSFWorkbook(fileStream);
			 excelSheet = excel.getSheet("Sheet1");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public HashMap<String,Integer> getColumnName() {
		HashMap<String,Integer> columnMap = new HashMap<>(); 
		XSSFRow r = excelSheet.getRow(0);
		for(int i=0;i<=r.getLastCellNum();i++) {
			XSSFCell cell = r.getCell(i);
			if(cell != null) {
				columnMap.put(cell.getStringCellValue().trim(), i);
			}
		}
		return columnMap;
	}
	
	public String getCellData(int rowNum, String columnName) {
		HashMap<String,Integer> columnMap = getColumnName();
		int colNum = columnMap.get(columnName);
		
		XSSFRow row = excelSheet.getRow(rowNum);
		XSSFCell cell=null;
		if(row != null) {
			cell = row.getCell(colNum);
		}
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	}
	
	public  int getLastRowLen() {
		return excelSheet.getLastRowNum();
	}
	
}
