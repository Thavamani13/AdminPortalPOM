package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestBase {
	
	static String chrome = "D:\\photon_workspace\\adminportal\\driver\\chromedriver.exe";

	public static WebDriver driver;
	
	public static   Properties prop;

	
	public TestBase() {
		
		prop = new Properties();
		
		
		
		  try {
			  
			FileInputStream input = new FileInputStream("D:\\photon_workspace\\adminportal\\config.properties");
			
			prop.load(input);
			
		} 
		  
		  catch (FileNotFoundException e) {		
			e.printStackTrace();
		}
		  

		  catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	

	
	

	public static void initialization() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", chrome);

		driver = new ChromeDriver();
		
		
		driver.get("http://10.10.88.52:8080/NPWeb/home.do");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		
		driver.findElement(By.name("userId")).sendKeys("tmurugan");
		driver.findElement(By.name("password")).sendKeys("Jan@123m");
		Thread.sleep(5000);
		driver.findElement(By.className("loginButton")).click();

		

		System.out.println(driver.getTitle());
	
	
	
	}
}
