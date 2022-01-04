package br.com.vobi.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *  Classse com responsabilidade de realizar as conversões entre datas
 * @author Saulo Martins Soares da Fonseca
 *
 */
public class DateUitl {
	
	/**
	 * Metodo que converte a data com formato Long para dd/MM/yyyy
	 * @param dateLong data que será convertida
	 * @return String
	 */
	public static String converterData(String dateLong) {
		Long date = Long.valueOf(dateLong);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate = dateFormat.format(date);
		return strDate;  
	}

}
