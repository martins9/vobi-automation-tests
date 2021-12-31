package br.com.vobi.utils;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeitorExcel {

	private static HashMap<String, String> lerExcel() {
		
		HashMap<String, String> data = null;
		
		try {
			data = new HashMap<String, String>(); 
			String projectPath = System.getProperty("user.dir");
			XSSFWorkbook workbook = new XSSFWorkbook(projectPath + "/Massa/massa_dados_novocliente.xlsx");
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			for(int i=0;i<sheet.getRow(0).getLastCellNum();i ++) {
				
				if(sheet.getRow(1).getCell(i).getCellType() == CellType.STRING) {
					data.put(sheet.getRow(0).getCell(i).getStringCellValue(), sheet.getRow(1).getCell(i).getStringCellValue());
				}
				else if(sheet.getRow(1).getCell(i).getCellType() == CellType.NUMERIC){
					if(sheet.getRow(1).getCell(i).getDateCellValue() != null) {
						data.put(sheet.getRow(0).getCell(i).getStringCellValue(), String.valueOf(sheet.getRow(1).getCell(i).getDateCellValue().getTime()));
					}
					else{
						data.put(sheet.getRow(0).getCell(i).getStringCellValue(), String.valueOf(Math.round(sheet.getRow(1).getCell(i).getNumericCellValue())));
					}
				}			
			}
			
			workbook.close();
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return data;
	}
	
	
	public static String obterElementoExcel(String chave) {
		
		HashMap<String, String> data = lerExcel();
		return data.get(chave);
	}
	
}
