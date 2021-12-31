package br.com.vobi.Login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.vobi.PageObjects.CadastrarNovoClientePage;
import br.com.vobi.PageObjects.LoginPage;
import br.com.vobi.PageObjects.MeusClientesPesquisaPage;
import br.com.vobi.PageObjects.SessaoLateralPage;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void BeforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	/*
	@AfterEach
	public void AfterEach() {
		this.paginaDeLogin.fecharBrowser();
	}*/
	
	@Test
	public void cadastrarNovoCliente() throws InterruptedException {
		
		SessaoLateralPage paginaPrincipal = paginaDeLogin.preencherFormularioLoginSenha().acionarButaoLogin();
		CadastrarNovoClientePage cadastrarNovoClientePage = paginaPrincipal.acessarSessaoCadastrarNovosClientes().acionarButaoAdicionarNovoCliente();
		MeusClientesPesquisaPage meusClientesPesquisarPage = cadastrarNovoClientePage.preencherFormularioNovoCliente().acionarButaoSalvar();
		
		//"Falta incluir os asserts"
	}
		
}
