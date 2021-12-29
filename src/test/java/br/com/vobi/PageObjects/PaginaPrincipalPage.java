package br.com.vobi.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.vobi.xml.LeitorXML;

public class PaginaPrincipalPage extends PageObject{
	
	public PaginaPrincipalPage(WebDriver browser) {
		super(browser);
	}

	public MeusClientesPage acionarSessaoClientesFornecedores() {
		
		try {
			Thread.sleep(1000);
			browser.findElement(By.xpath(LeitorXML.leitorXML("butaoSessaoClienteFornecedores"))).click();
			browser.findElement(By.xpath(LeitorXML.leitorXML("butaoSessaoCliente"))).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new MeusClientesPage(browser);
	}
}
