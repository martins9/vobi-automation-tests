package br.com.vobi.Login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.vobi.PageObjects.CadastrarNovoClientePage;
import br.com.vobi.PageObjects.LoginPage;
import br.com.vobi.PageObjects.MeusClientesPesquisaPage;
import br.com.vobi.PageObjects.SessaoLateralPage;

/**
 * Classe responsável por executar o teste UI de cadastrar um novo cliente
 * @author saulo
 *
 */

public class CadastrarNovoCliente {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void BeforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void AfterEach() {
		this.paginaDeLogin.fecharBrowser();
	}
	
	@Test
	public void cadastrarNovoCliente() throws InterruptedException {
		
		SessaoLateralPage paginaPrincipal = paginaDeLogin.preencherFormularioLoginSenha().acionarBotaoLogin();
		CadastrarNovoClientePage cadastrarNovoClientePage = paginaPrincipal.acessarSessaoCadastrarNovosClientes().acionarBotaoAdicionarNovoCliente();
		MeusClientesPesquisaPage meusClientesPesquisarPage = cadastrarNovoClientePage.preencherFormularioNovoCliente().acionarBotaoSalvar();
		
		Assertions.assertTrue(meusClientesPesquisarPage.pequisarClienteCadastrado().clienteCadastradoPresente());
	}
		
}
