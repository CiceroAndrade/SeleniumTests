package pageTests;

import org.testng.annotations.Test;
import dataProvider.LoginGpjDataProvider;
import utils.UtilGeral;
import pageTasks.LoginGpjPageTasks;
public class TestaLogin extends PageMaster {
	private LoginGpjPageTasks tela_de_login = new LoginGpjPageTasks(driver);
	//private EntradaAdvogadoTasks tela_de_entrada = new EntradaAdvogadoTasks(driver);

	@Test(priority = 1, dataProvider = "dadosAcesso", dataProviderClass = LoginGpjDataProvider.class)
	public void testa_login(String usuario, String senha) {
		System.out.println("Teste login iniciado");
		
		UtilGeral.pause(10);
		tela_de_login.insereUsuario(usuario);
		tela_de_login.insereSenha(senha);
		tela_de_login.clicaLogar();
		tela_de_login.selecionaSistema();
		tela_de_login.clicaEntrar();
		System.out.println("Teste login conclu�do");
		UtilGeral.setPausaExpliMs(5);

	}

}