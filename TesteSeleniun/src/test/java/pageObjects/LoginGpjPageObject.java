package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginGpjPageObject {
	public static WebElement campoUsuario(WebDriver driver){
		return driver.findElement(By.name("login"));		
	}
	
	public static WebElement campoSenha(WebDriver driver){
		return	driver.findElement(By.name("senha"));
	}
	
	public static WebElement btnConfirmar(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Entrar']"));	 	
	}
	
	public static WebElement cbSistemas(WebDriver driver) {
		return driver.findElement(By.name("idItemMenu"));
	} 
	
	public static WebElement btnEntrar (WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Entrar']"));
		 
	}
}
