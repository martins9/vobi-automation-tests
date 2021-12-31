package br.com.vobi.PageObjects;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.By;

import br.com.vobi.utils.LeitorXML;
	
public class LoginPage extends PageObject{
	
	private ResourceBundle labels = ResourceBundle.getBundle("locale");
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(labels.getString("url"));
		this.browser.manage().window().maximize();
	}

	public LoginPage preencherFormularioLoginSenha() {
		
		browser.findElement(By.id(LeitorXML.leitorXML("campo_email"))).sendKeys(labels.getString("user"));
		browser.findElement(By.id(LeitorXML.leitorXML("campo_senha"))).sendKeys(labels.getString("password"));
		return this;
	}
	
	public SessaoLateralPage acionarButaoLogin() {
		try {
			Thread.sleep(1000);
			browser.findElement(By.xpath(LeitorXML.leitorXML("butaoLogin"))).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SessaoLateralPage(browser);
	}
	
}
