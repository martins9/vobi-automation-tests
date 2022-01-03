package br.com.vobi.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.vobi.utils.LeitorXML;

/**
 *  Classe responsável pelo PageObject Sessao Lateral
 * @author saulo
 *
 */
public class SessaoLateralPage extends PageObject{
	
	/**
	 * Construtor da classe
	 * @param browser
	 */
	public SessaoLateralPage(WebDriver browser) {
		super(browser);
	}
	
	/**
	 *  Metodo responsável por acionar os botões que ficam na sessão Clientes e Fornecedores
	 * @return
	 */
	public MeusClientesPesquisaPage acessarSessaoCadastrarNovosClientes() {
		
		try {
			Thread.sleep(1500);
			browser.findElement(By.xpath(LeitorXML.leitorXML("botaoSessaoClienteFornecedores"))).click();
			browser.findElement(By.xpath(LeitorXML.leitorXML("botaoSessaoCliente"))).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new MeusClientesPesquisaPage(browser);
	}
}
