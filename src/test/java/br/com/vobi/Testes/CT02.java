package br.com.vobi.Testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.vobi.PageObjects.CadastrarNovoClientePage;
import br.com.vobi.PageObjects.LoginPage;
import br.com.vobi.PageObjects.SessaoLateralPage;
import br.com.vobi.utils.LoadData;

/**
 *<pre>
 *Cenário de Teste: Cadastrar um novo cliente
 *CT02: Realizar o cadastramento de um novo cliente com dados inválidos.
 *@author Saulo Martins Soares da Fonseca
 *<pre>
 *
 */
public class CT02 {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void BeforeEach() {
		this.paginaDeLogin = new LoginPage();
		 new LoadData("massa_dados_novocliente_CT02.xlsx");
	}
	
	@AfterEach
	public void AfterEach() {
		this.paginaDeLogin.fecharBrowser();
	}
	
	@Test
	public void cadastrarNovoCliente() throws InterruptedException {
		
		SessaoLateralPage paginaPrincipal = paginaDeLogin.preencherFormularioLoginSenha().acionarBotaoLogin();
		CadastrarNovoClientePage cadastrarNovoClientePage = paginaPrincipal.acessarSessaoCadastrarNovosClientes().acionarBotaoAdicionarNovoCliente();
		cadastrarNovoClientePage.preencherFormularioNovoCliente().acionarBotaoSalvar();
		
		Assertions.assertTrue(cadastrarNovoClientePage.validarCamposInvalidos());
		Assertions.assertTrue(cadastrarNovoClientePage.verificaPermanenciacadastrarNovoClientePage());
	}
		
}
