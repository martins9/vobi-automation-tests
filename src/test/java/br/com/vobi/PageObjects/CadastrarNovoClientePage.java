package br.com.vobi.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.vobi.utils.DateUitl;
import br.com.vobi.utils.LeitorExcel;
import br.com.vobi.utils.LeitorXML;

public class CadastrarNovoClientePage extends PageObject {

	public CadastrarNovoClientePage(WebDriver browser) {
		super(browser);
	}
	
	
	public CadastrarNovoClientePage preencherFormularioNovoCliente() throws InterruptedException {
		
		Thread.sleep(1000);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_NomeCompleto"))).sendKeys(LeitorExcel.obterElementoExcel("Nome Completo"));
		Thread.sleep(500);
		if(LeitorExcel.obterElementoExcel("Ativo?").equals("Sim") && !browser.findElement(By.xpath(LeitorXML.leitorXML("butaoCheck_Ativo"))).isSelected()) {
			browser.findElement(By.xpath(LeitorXML.leitorXML("butaoCheck_Ativo"))).click();
		}
		else if (LeitorExcel.obterElementoExcel("Ativo?").equals("Nao") && browser.findElement(By.xpath(LeitorXML.leitorXML("butaoCheck_Ativo"))).isSelected()) {
			browser.findElement(By.xpath(LeitorXML.leitorXML("butaoCheck_Ativo"))).click();
		}
		
		Thread.sleep(1000);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_DataNascimento"))).sendKeys(DateUitl.converterData(LeitorExcel.obterElementoExcel("DatadeNascimento")));
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_DataNascimento"))).sendKeys(Keys.ESCAPE);
		
		if(LeitorExcel.obterElementoExcel("Pessoa Fisica") !=null) {
			if(!browser.findElement(By.xpath(LeitorXML.leitorXML("butaoRadio_PessoaFisica"))).isSelected()){
				browser.findElement(By.xpath(LeitorXML.leitorXML("butaoRadio_PessoaFisica"))).click();
				browser.findElement(By.id(LeitorXML.leitorXML("campo_CPF_CNPJ"))).sendKeys(LeitorExcel.obterElementoExcel("CPF"));
			}
		}
		else if (LeitorExcel.obterElementoExcel("Pessoa Juridica") !=null) {
			if(!browser.findElement(By.xpath(LeitorXML.leitorXML("butaoRadio_PessoaJuridica"))).isSelected()) {
				browser.findElement(By.xpath(LeitorXML.leitorXML("butaoRadio_PessoaJuridica"))).click();
				browser.findElement(By.id(LeitorXML.leitorXML("campo_CPF_CNPJ"))).sendKeys(LeitorExcel.obterElementoExcel("CNPJ"));
			}
		}

		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_RG"))).sendKeys(LeitorExcel.obterElementoExcel("RG"));
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_emailNovoCliente"))).sendKeys(LeitorExcel.obterElementoExcel("E-mail"));
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Telefone"))).sendKeys(LeitorExcel.obterElementoExcel("Telefone"));
		browser.findElement(By.id(LeitorXML.leitorXML("campo_CEP"))).sendKeys(LeitorExcel.obterElementoExcel("CEP"));
		
		String[] end = LeitorExcel.obterElementoExcel("Endereco").split("/");
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Endereco"))).sendKeys(end[0]);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Numero"))).sendKeys(end[1]);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Complemento"))).sendKeys(end[0]);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Bairro"))).sendKeys(LeitorExcel.obterElementoExcel("Bairro"));
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Cidade"))).sendKeys(LeitorExcel.obterElementoExcel("Cidade"));
		Thread.sleep(500);
		browser.findElement(By.xpath(LeitorXML.leitorXML("comboBox_Estado"))).click();
		browser.findElement(By.xpath(LeitorXML.leitorXML("comboBox_Estado"))).sendKeys(LeitorExcel.obterElementoExcel("Estado") + Keys.ENTER);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_OBS"))).sendKeys(LeitorExcel.obterElementoExcel("OBS"));
		
		return this;
	}

	public MeusClientesPesquisaPage acionarButaoSalvar() {
		browser.findElement(By.xpath(LeitorXML.leitorXML("butao_Salvar"))).click();
		return new MeusClientesPesquisaPage(browser);
	}
}
