package br.com.vobi.utils;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *  Classe que manipula o Excel
 * @author Saulo Martins Soares da Fonseca
 *
 */
public class LeitorExcel {
	
	/**
	 * Metodo que manipula e tem como retorno um Map <K,V>
	 * @param nomeMassa nome do arquivo Excel
	 * @return HashMap<String, String>
	 */
	private static HashMap<String, String> lerExcel(String nomeMassa) {
		
		HashMap<String, String> data = null;
		
		try {
			data = new HashMap<String, String>(); 
			String projectPath = System.getProperty("user.dir");
			XSSFWorkbook workbook = new XSSFWorkbook(projectPath + "/Massa/"+nomeMassa);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			for(int i=0;i<sheet.getRow(0).getLastCellNum();i ++) {
				
				if(sheet.getRow(1).getCell(i).getCellType() == CellType.STRING ||
						sheet.getRow(1).getCell(i).getCellType() == CellType.BLANK) {
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
	
	/**
	 * Metodo que cria um Map<K,V> em que a chave é nome do campo e valor é conteúdo
	 * do campos, ambos do Excel.
	 * @param chave nome do elemento que sera pesquisado no Map
	 * @param nomeMassa nome do arquivo Excel
	 * @return String
	 */
	public static String obterElementoExcel(String chave, String nomeMassa) {
		
		HashMap<String, String> data = lerExcel(nomeMassa);
		return data.get(chave);
	}
	
}
