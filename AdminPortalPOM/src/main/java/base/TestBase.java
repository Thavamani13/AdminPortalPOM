package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestBase {
	
	static String chrome = "D:\\Selenium\\chromedriver.exe";

	public static WebDriver driver;
	
	public static   Properties prop;

	
	public TestBase() {
		
		prop = new Properties();
		
		
		
		  try {
			  
			FileInputStream input = new FileInputStream("C:\\Users\\pkrishnamoorthy\\git\\AdminPortalPOM\\AdminPortalPOM\\config.properties");
			
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
	
	public static int TestpartnerSourceId_DB(String psd) throws Exception
	
	{
		
		int Expected_count = 0;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@10.10.88.224:9101/DBRTQ","apdb","yu8LFZtW172KYmPy"); 
		
		Statement stmt=con.createStatement();   
		
		ResultSet result=stmt.executeQuery("select count(*) from en_fp_member_detail where PARTNER_SOURCE_ID ='" +psd +"'");
		
		//ResultSet result = stmt.executeQuery("select count(*) from en_member where member_id IN (SELECT mem.member_id memId FROM en_member mem  WHERE   (MEM.FP_ACCOUNT_ID IS NOT NULL OR MEM.MEMBER_TYPE_ID =1) AND mem.first_name='" + psd + "')");
		
		while(result.next()){
			Expected_count =result.getInt(1);
			
		}
		
		System.out.println("Count as per the DB " + Expected_count);
		
		return Expected_count;
	}
	
public static int testPartnerMemberId_DB(String v2MemberId) throws Exception
	
	{
		
		int Expected_count = 0;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@10.10.88.224:9101/DBRTQ","apdb","yu8LFZtW172KYmPy"); 
		
		Statement stmt=con.createStatement();   
		
		//ResultSet result=stmt.executeQuery("select count(*) from en_fp_member_detail where PARTNER_SOURCE_ID ='" +psd +"'");
		
		ResultSet result = stmt.executeQuery("select count(*) from en_member where member_id IN (SELECT mem.member_id memId FROM en_member mem  WHERE   (MEM.FP_ACCOUNT_ID IS NOT NULL OR MEM.MEMBER_TYPE_ID =1) AND mem.first_name='" + v2MemberId + "')");
		
		while(result.next()){
			Expected_count =result.getInt(1);
			
		}
		
		System.out.println("Count as per the DB " + Expected_count);
		
		return Expected_count;
	}

public static void testFPAccountId_DB(int id) throws Throwable {
	
	int MemberId=0;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@10.10.88.224:9101/DBRTQ","apdb","yu8LFZtW172KYmPy"); 
	
	id = 7014988;
	
	Statement stmt=con.createStatement();  
	
	ResultSet rs=stmt.executeQuery("select member_id from endbown.en_member where fp_account_id =" +id); 
	
	while(rs.next())  
	{
		System.out.println(rs.getInt(1));
		MemberId= rs.getInt(1);
	}
}

	public static void sendKeys(WebElement element,String input)
	{
	
		element.sendKeys(input);
	
	}

public static void keysEnter(WebElement element)
{
	
	Keys keyEnter = Keys.ENTER;
	
	element.sendKeys(keyEnter);
}

public static void clear(WebElement element)
{
	
	
}
}
