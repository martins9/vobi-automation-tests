package br.com.vobi.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUitl {
	
	public static String converterData(String dateLong) {
		Long date = Long.valueOf(dateLong);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate = dateFormat.format(date);
		return strDate;  
	}

}
