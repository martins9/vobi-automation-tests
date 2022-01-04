package br.com.vobi.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.vobi.utils.LeitorExcel;
import br.com.vobi.utils.LeitorXML;
import br.com.vobi.utils.LoadData;

/**
 * Classe responsável pelo Page Object Meus Clientes Pesquisa
 * @author Saulo Martins Soares da Fonseca
 *
 */
public class MeusClientesPesquisaPage extends PageObject{
	
	private String nomeArquivo = LoadData.getNomeArquivo();
	/**
	 * Construtor da classe
	 * @param browser
	 */
	public MeusClientesPesquisaPage(WebDriver browser) {
		super(browser);
	}
	
	/**
	 * Metodo responsável por acionar o 
	 * @return CadastrarNovoClientePage
	 */
	public CadastrarNovoClientePage acionarBotaoAdicionarNovoCliente() {
		browser.findElement(By.xpath(LeitorXML.leitorXML("botaoAdicionarCliente"))).click();
		return new CadastrarNovoClientePage(browser);
	}
	
	/**
	 * Metodo que realiza a pesquisa de um cliente cadastrado
	 * @return MeusClientesPesquisaPage
	 */
	public MeusClientesPesquisaPage pequisarClienteCadastrado() {
		
		try {
			String varAtivo = LeitorExcel.obterElementoExcel("Ativo?",nomeArquivo).equals("Sim") ? "Ativo": "Inativo";
			Thread.sleep(500);
			browser.findElement(By.xpath(LeitorXML.leitorXML("botao_PesquisarMeusClientes"))).click();
			browser.findElement(By.xpath(LeitorXML.leitorXML("campo_NomeEmailMeusClientes"))).sendKeys(LeitorExcel.obterElementoExcel("Nome Completo",nomeArquivo));
			Thread.sleep(1000);
			browser.findElement(By.xpath(LeitorXML.leitorXML("comboBox_AtivoMeusClientes"))).click();
			browser.findElement(By.xpath(LeitorXML.leitorXML("comboBox_AtivoMeusClientes"))).sendKeys(varAtivo + Keys.ENTER);
			browser.findElement(By.xpath(LeitorXML.leitorXML("botao_confirmarMeusClientes"))).click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * Metodo que valida os dados do cliente a partir do filtro na página Meus Clientes Pesquisa
	 * @return MeusClientesPesquisaPage
	 */
	public boolean validarClienteCadastrado() {
		
		boolean varBool = false;
		try {
			String varAtivo = LeitorExcel.obterElementoExcel("Ativo?",nomeArquivo).equals("Sim") ? "Ativo": "Inativo";
			Thread.sleep(1000);
			WebElement table = browser.findElement(By.xpath(LeitorXML.leitorXML("tabela_ClientesCadastrados")));
			List<WebElement> tableRows = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td"));
			varBool = tableRows.get(1).getText().equalsIgnoreCase(LeitorExcel.obterElementoExcel("Nome Completo",nomeArquivo)) &&
					tableRows.get(2).getText().equals(LeitorExcel.obterElementoExcel("E-mail",nomeArquivo)) &&
					tableRows.get(3).getText().equals(LeitorExcel.obterElementoExcel("Telefone",nomeArquivo).replaceAll("[()\\s-]+", "")) &&
					tableRows.get(4).getText().equals(varAtivo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return varBool;
	}
	
}
