package br.com.vobi.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.vobi.utils.LeitorXML;

public class SessaoLateralPage extends PageObject{
	
	public SessaoLateralPage(WebDriver browser) {
		super(browser);
	}

	public MeusClientesPesquisaPage acessarSessaoCadastrarNovosClientes() {
		
		try {
			Thread.sleep(1500);
			browser.findElement(By.xpath(LeitorXML.leitorXML("butaoSessaoClienteFornecedores"))).click();
			browser.findElement(By.xpath(LeitorXML.leitorXML("butaoSessaoCliente"))).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new MeusClientesPesquisaPage(browser);
	}
}
