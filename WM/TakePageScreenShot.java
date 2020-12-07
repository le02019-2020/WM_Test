package WM;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakePageScreenShot {

		
	public static void main(String[] args) throws IOException {
		
		
	WebDriver driver ;
	
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.get("https://www.lafitness.com/pages/login.aspx");
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("txtUser"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement signinButton = driver.findElement(By.id("ctl00_MainContent_Login1_btnLogin"));
		WebElement forgotPWD = driver.findElement(By.linkText("Forgot your password?"));
		
		email.sendKeys("LA@gmail.com");
		password.sendKeys("LA@12345");
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./target/screenshots/pag.png"));
		
			
		takeElementsScreenshot(email, "email1");
		takeElementsScreenshot(password, "password1");
		takeElementsScreenshot(signinButton, "signinButton1");
		takeElementsScreenshot(forgotPWD, "forgotPWD1");
		
		driver.quit();

	}
	
	public static void takeElementsScreenshot(WebElement element, String fileName){
		
		TakesScreenshot scrShot = ((TakesScreenshot)element);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./target/screenshots/" +fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
