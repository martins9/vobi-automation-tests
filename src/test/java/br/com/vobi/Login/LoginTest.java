package br.com.vobi.Login;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import br.com.vobi.PageObjects.LoginPage;
import br.com.vobi.PageObjects.PaginaPrincipalPage;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void BeforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
//	@AfterEach
//	public void AfterEach() {
//		this.paginaDeLogin.fecharBrowser();
//	}
	
	@Test
	public void cadastrarNovoCliente() throws InterruptedException {
		
		PaginaPrincipalPage paginaPrincipal = paginaDeLogin.preencherFormularioLoginSenha().acionarButaoLogin();
		paginaPrincipal.acionarSessaoClientesFornecedores();
	}
		
}
