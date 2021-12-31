package br.com.vobi.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.vobi.utils.DateUitl;
import br.com.vobi.utils.LeitorExcel;
import br.com.vobi.utils.LeitorXML;

public class MeusClientesPesquisaPage extends PageObject{

	public MeusClientesPesquisaPage(WebDriver browser) {
		super(browser);
	}

	public CadastrarNovoClientePage acionarButaoAdicionarNovoCliente() {
		browser.findElement(By.xpath(LeitorXML.leitorXML("butaoAdicionarCliente"))).click();
		return new CadastrarNovoClientePage(browser);
	}
	
}
