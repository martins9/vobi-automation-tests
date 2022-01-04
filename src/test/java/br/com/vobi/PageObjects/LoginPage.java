package br.com.vobi.PageObjects;

import java.util.ResourceBundle;

import org.openqa.selenium.By;

import br.com.vobi.utils.LeitorXML;

/**
 *  Classe responsável pelo PageObject Login
 * @author Saulo Martins Soares da Fonseca
 *
 */
public class LoginPage extends PageObject{
	
	/**
	 * Metodo estatico que obtem os elementos dentro locale.properties
	 */
	private ResourceBundle labels = ResourceBundle.getBundle("locale");
	
	/**
	 *  Construtor do Login Page
	 */
	public LoginPage() {
		super(null);
		this.browser.navigate().to(labels.getString("url"));
		this.browser.manage().window().maximize();
	}
	
	/**
	 *  Metodo que preenche o formulario de login
	 * @return LoginPage
	 */
	public LoginPage preencherFormularioLoginSenha() {
		
		browser.findElement(By.id(LeitorXML.leitorXML("campo_email"))).sendKeys(labels.getString("user"));
		browser.findElement(By.id(LeitorXML.leitorXML("campo_senha"))).sendKeys(labels.getString("password"));
		return this;
	}
	
	/**
	 *  Metodo responsável por acessar a sessão Clientes dentro de Cientes e Fornecedores
	 * @return SessaoLateralPage
	 */
	public SessaoLateralPage acionarBotaoLogin() {
		try {
			Thread.sleep(1000);
			browser.findElement(By.xpath(LeitorXML.leitorXML("botaoLogin"))).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new SessaoLateralPage(browser);
	}
	
}
