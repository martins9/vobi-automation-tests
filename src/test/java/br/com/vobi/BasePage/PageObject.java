package br.com.vobi.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser;
	
	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\Pessoal\\qa-code\\vobi-automation-tests\\drivers\\chromedriver.exe");
		if(browser == null) {
			this.browser = new ChromeDriver();
		}
		else {
			this.browser = browser;
		}
	}
	
	public void fecharBrowser() {
		this.browser.quit();		
	}
}
