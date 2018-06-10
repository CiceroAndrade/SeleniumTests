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
	
	/**
	 * Modular Driven Framework example. In most of the web application we have few set of actions which are always 
	 * executed in the series of actions. Rather than writing those actions again and again in our test, we can club 
	 * those actions in to a method and then calling that method in our test script. Modularity avoids duplicacy of code.
	 * We can simple wrap repeated functionality in a method!
	 * @param usuario
	 * @param senha
	 */
	public void efetuaLogin (String usuario, String senha) {
		UtilGeral.pausa(5);
		LoginGpjPageObject.campoUsuario(driver).sendKeys(usuario);
		LoginGpjPageObject.campoSenha(driver).sendKeys(senha);
		LoginGpjPageObject.btnEntrar(driver).click();
		UtilGeral.esperaVisibilidade(driver, LoginGpjPageObject.btnEntrar(driver));
		Select select = new Select(LoginGpjPageObject.cbSistemas(driver));
		select.selectByVisibleText("GPJA - Processos Judiciais");
		LoginGpjPageObject.btnEntrar(driver).click();
	}
	
}
