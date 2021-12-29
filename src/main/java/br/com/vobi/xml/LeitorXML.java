package br.com.vobi.xml;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class LeitorXML {
	
	public static String leitorXML(String chave) {
		String value = null;
		Properties p = new Properties();
		
		try
		{
			FileInputStream fis = new FileInputStream("D:\\Documentos\\Pessoal\\qa-code\\vobi-automation-tests\\Locators\\elementospagina.xml");
			p.loadFromXML(fis);
			Enumeration<?> enumeration = p.propertyNames();

			while (enumeration.hasMoreElements())
			{
				String key = (String) enumeration.nextElement();
				
				if(key.equalsIgnoreCase(chave)) {
					value = p.getProperty(key);
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return value;
		
	}

}
