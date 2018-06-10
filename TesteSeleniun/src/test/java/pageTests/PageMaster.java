package pageTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import config.Configs;
import config.Drivers;
import utils.InterNaveg;

public class PageMaster {
	//public static WebDriver driver= Drivers.getChromeDriver();
	public static WebDriver driver= Drivers.getLocalChromeDriver();
	String URL = Configs.URLPrincipal;	
	//PageMaster.driver= Drivers.getIEDriver();
	//PageMaster.driver= Drivers.getFirefoxDriver();
	//PageMaster.driver= Drivers.getOperaDriver();
	
	@BeforeTest
	public void beforeTest() {
		InterNaveg.setUrl(driver, URL);
	}

	@AfterTest
	public void afterTest() {
		InterNaveg.encerraNavegador(driver);
	}

}
