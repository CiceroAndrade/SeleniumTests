package utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilGeral {
	WebDriver driver;
	// Construtor que recebe o controle do driver/navegador
	public UtilGeral(WebDriver driver) {
		this.driver = driver;
	}

	public static void setPausaExpliMs(int tmseg){
		try {
			Thread.sleep(tmseg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void pause(int segundos){
		try {
			Thread.sleep(segundos*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void visibilityElementWait (WebDriver driver, WebElement element) {
		WebDriverWait espera = new WebDriverWait(driver, 100);
		try {
			espera.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException | NullPointerException e)  {
			UtilGeral.pause(5);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void setPausaImpliSeg(WebDriver driver, int tmseg){
		driver.manage().timeouts().implicitlyWait(tmseg, TimeUnit.SECONDS);	
	}
	
	public static void setMensConsole(String texto){
		System.out.println(texto);
	}

	public void getEvidTela(WebDriver driver) throws IOException{
		// Processo de criacao de nomenclatura com base em data, adicao do sufixo .png
        Date d = new Date();
        String date = d.toString().replaceAll(":","_");
        String fileName = date + ".png";
        // Aponta o diretorio para guardar a evidencia e tira uma foto da tela
        String directory = "file:///Users/Cicero/Public/PRINT";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Armazena e cria o arquivo de evidencia no diretorio com o nome definido
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}

	public static String getDateTime(String dateformat){
		SimpleDateFormat dateTime = new SimpleDateFormat(dateformat);
		Calendar calendario = Calendar.getInstance();
        return dateTime.format(calendario.getTime());
	}
	
	public static String getDataFutura (String dateFormat, int mesesFuturos) {
		SimpleDateFormat dateTime = new SimpleDateFormat(dateFormat);
		Calendar c = Calendar.getInstance();
		//Adiciona dias
		c.add(Calendar.DAY_OF_YEAR, mesesFuturos);
		return  dateTime.format(c.getTime());
	}
}

