package br.com.vobi.PageObjects;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.vobi.utils.DateUitl;
import br.com.vobi.utils.LeitorExcel;
import br.com.vobi.utils.LeitorXML;
import br.com.vobi.utils.LoadData;

/**
 *  Classe responsável pelo Page Object Cadastrar Novo Cliente
 * @author Saulo Martins Soares da Fonseca
 *
 */
public class CadastrarNovoClientePage extends PageObject {
		
	private String nomeArquivo = LoadData.getNomeArquivo();
	private ResourceBundle labels = ResourceBundle.getBundle("locale");
	/**
	 * Construtor da classe
	 * @param browser
	 */
	public CadastrarNovoClientePage(WebDriver browser) {
		super(browser);
	}
	
	/**
	 * Metodo responsavel por preencher o formulario de um novo cliente
	 * @return CadastrarNovoClientePage
	 * @throws InterruptedException
	 */
	public CadastrarNovoClientePage preencherFormularioNovoCliente() throws InterruptedException {
		
		
		Thread.sleep(1000);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_NomeCompleto"))).sendKeys(LeitorExcel.obterElementoExcel("Nome Completo", nomeArquivo));
		Thread.sleep(500);
		if(LeitorExcel.obterElementoExcel("Ativo?", nomeArquivo).equals("Sim") && !browser.findElement(By.xpath(LeitorXML.leitorXML("botaoCheck_Ativo"))).isSelected()) {
			browser.findElement(By.xpath(LeitorXML.leitorXML("botaoCheck_Ativo"))).click();
		}
		else if (LeitorExcel.obterElementoExcel("Ativo?", nomeArquivo).equals("Nao") && browser.findElement(By.xpath(LeitorXML.leitorXML("botaoCheck_Ativo"))).isSelected()) {
			browser.findElement(By.xpath(LeitorXML.leitorXML("botaoCheck_Ativo"))).click();
		}
		
		Thread.sleep(1000);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_DataNascimento"))).sendKeys(DateUitl.converterData(LeitorExcel.obterElementoExcel("DatadeNascimento", nomeArquivo)));
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_DataNascimento"))).sendKeys(Keys.ESCAPE);
		
		if(LeitorExcel.obterElementoExcel("Pessoa Fisica", nomeArquivo) !=null) {
			if(!browser.findElement(By.xpath(LeitorXML.leitorXML("botaoRadio_PessoaFisica"))).isSelected()){
				browser.findElement(By.xpath(LeitorXML.leitorXML("botaoRadio_PessoaFisica"))).click();
				browser.findElement(By.id(LeitorXML.leitorXML("campo_CPF_CNPJ"))).sendKeys(LeitorExcel.obterElementoExcel("CPF", nomeArquivo));
			}
		}
		else if (LeitorExcel.obterElementoExcel("Pessoa Juridica", nomeArquivo) !=null) {
			if(!browser.findElement(By.xpath(LeitorXML.leitorXML("botaoRadio_PessoaJuridica"))).isSelected()) {
				browser.findElement(By.xpath(LeitorXML.leitorXML("botaoRadio_PessoaJuridica"))).click();
				browser.findElement(By.id(LeitorXML.leitorXML("campo_CPF_CNPJ"))).sendKeys(LeitorExcel.obterElementoExcel("CNPJ", nomeArquivo));
			}
		}

		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_RG"))).sendKeys(LeitorExcel.obterElementoExcel("RG", nomeArquivo));
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_emailNovoCliente"))).sendKeys(LeitorExcel.obterElementoExcel("E-mail", nomeArquivo));
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Telefone"))).sendKeys(LeitorExcel.obterElementoExcel("Telefone", nomeArquivo));
		browser.findElement(By.id(LeitorXML.leitorXML("campo_CEP"))).sendKeys(LeitorExcel.obterElementoExcel("CEP", nomeArquivo));
		
		String[] end = LeitorExcel.obterElementoExcel("Endereco", nomeArquivo).split("/");
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Endereco"))).sendKeys(end[0]);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Numero"))).sendKeys(end[1]);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Complemento"))).sendKeys(end[0]);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Bairro"))).sendKeys(LeitorExcel.obterElementoExcel("Bairro", nomeArquivo));
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_Cidade"))).sendKeys(LeitorExcel.obterElementoExcel("Cidade", nomeArquivo));
		Thread.sleep(500);
		browser.findElement(By.xpath(LeitorXML.leitorXML("comboBox_Estado"))).click();
		Thread.sleep(500);
		browser.findElement(By.xpath(LeitorXML.leitorXML("comboBox_Estado"))).sendKeys(LeitorExcel.obterElementoExcel("Estado", nomeArquivo) + Keys.ENTER);
		browser.findElement(By.xpath(LeitorXML.leitorXML("campo_OBS"))).sendKeys(LeitorExcel.obterElementoExcel("OBS", nomeArquivo));
		
		return this;
	}
	
	/**
	 *  Método responsável por acionar o botão de Salvar que cadastra um novo cliente
	 * @return MeusClientesPesquisaPage
	 */
	public MeusClientesPesquisaPage acionarBotaoSalvar() {
		browser.findElement(By.xpath(LeitorXML.leitorXML("botao_Salvar"))).click();
		return new MeusClientesPesquisaPage(browser);
	}
	
	/**
	 * Metodo que valida a mensagem do campo obrigatorio: Nome Completo
	 * @return boolean
	 */
	public boolean validarCamposObrigatorios() {
		return browser.findElement(By.xpath(LeitorXML.leitorXML("msg_CampoNomeObrigatorio"))).getText().equalsIgnoreCase(labels.getString("NomeCompletoObrigatorio"));
	}
	
	/**
	 * Metodo que verifica se permanece ainda na Tela: Cadastrar Novo Cliente
	 * @return boolean
	 */
	public boolean verificaPermanenciacadastrarNovoClientePage() {
		return browser.findElement(By.xpath(LeitorXML.leitorXML("titulo_CadastrarNovoCliente"))).getText().equalsIgnoreCase(labels.getString("TituloCadastraCliente"));
	}
	
	/**
	 * Metodo que valida as mensagens dos campos inválidos
	 * @return
	 */
	public boolean validarCamposInvalidos() {
		return browser.findElement(By.xpath(LeitorXML.leitorXML("msg_CampoEmailInvalido"))).getText().equalsIgnoreCase(labels.getString("EmailInvalido")) &&
		browser.findElement(By.xpath(LeitorXML.leitorXML("msg_CampoTelefonInvalido"))).getText().equalsIgnoreCase(labels.getString("TelefoneInvalido"));
	}
}
