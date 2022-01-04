package br.com.vobi.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *  Classe responsável por métodos e características em comum que serão 
 *  herdadas por outras classes
 * @author Saulo Martins Soares da Fonseca
 *
 */
public class PageObject {

	protected WebDriver browser;
	
	/**
	 * Constutor da classe que seta o driver do Chrome e inicializa o browser
	 * @param browser
	 */
	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\Pessoal\\qa-code\\vobi-automation-tests\\drivers\\chromedriver.exe");
		if(browser == null) {
			this.browser = new ChromeDriver();
		}
		else {
			this.browser = browser;
		}
	}


	/**
	 * Metodo que fechar o browser
	 */
	public void fecharBrowser() {
		this.browser.quit();		
	}

}
