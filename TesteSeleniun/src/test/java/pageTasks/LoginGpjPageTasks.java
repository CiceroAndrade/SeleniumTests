package pageTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.UtilGeral;
import pageObjects.LoginGpjPageObject;;

public class LoginGpjPageTasks {
	WebDriver driver;
	

	public LoginGpjPageTasks(WebDriver driver){
		this.driver = driver;
	}

	public void insereUsuario (String usuario){
		LoginGpjPageObject.campoUsuario(driver).sendKeys(usuario);
		
	}

	public void insereSenha (String senha) {
		LoginGpjPageObject.campoSenha(driver).sendKeys(senha);
	}
	
	public void clicaLogar (){
		LoginGpjPageObject.btnConfirmar(driver).click();
	}
	
	public void selecionaSistema () {
		Select select = new Select(LoginGpjPageObject.cbSistemas(driver));
		select.selectByVisibleText("GPJA - Processos Judiciais"); 
	}
	
	public void clicaEntrar () {
		LoginGpjPageObject.btnEntrar(driver).submit();
	}
	
	public void efetuaLogin (String usuario, String senha) {
		UtilGeral.pausa(5);
		LoginGpjPageObject.campoUsuario(driver).sendKeys(usuario);
		LoginGpjPageObject.campoSenha(driver).sendKeys(senha);
		LoginGpjPageObject.btnEntrar(driver).click();
		//Aguarda tela de sele��o de sistemas
		UtilGeral.esperaVisibilidade(driver, LoginGpjPageObject.btnEntrar(driver));
		Select select = new Select(LoginGpjPageObject.cbSistemas(driver));
		select.selectByVisibleText("GPJA - Processos Judiciais");
		LoginGpjPageObject.btnEntrar(driver).click();
	}
	
}
