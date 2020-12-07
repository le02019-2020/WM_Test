package WM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WMTest {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void setUp(){
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void LATest(){
		driver.get("https://www.lafitness.com/pages/login.aspx");
		System.out.println(driver.getTitle());
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
