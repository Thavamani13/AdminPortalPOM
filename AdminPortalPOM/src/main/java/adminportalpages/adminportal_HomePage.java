package adminportalpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.TestBase;

public class adminportal_HomePage extends TestBase{	
	
	
	
	

	@FindBy(xpath = "//a[text()='Report ']")
	WebElement Report;

	@FindBy(xpath = "//a[text()='Promotion ']")
	WebElement Promotion;

  
	
    @FindBy(xpath = "//a[text()='Transaction ']")
    WebElement Transaction;
	

	@FindBy(xpath = "//a[text()='Member ']")
	static
	WebElement Member;

	@FindBy(xpath = "//a[text()='Retailer ']")
	WebElement Retailer;
	

	@FindBy(xpath = "//a[text()='Administration ']")
	WebElement Administration;
		

	public adminportal_HomePage() {
		PageFactory.initElements(driver, this);
	}





	public void clickreport() {

		Report.click();

	}

	public void clickpromotion() {

		Promotion.click();

	}

	public void clickTransaction() {

	//	driver.findElement(By.xpath("//a[text()='Transaction ']")).click();
		
		
		Transaction.click();
		

	}

	public void clickmember() {

		Member.click();

	}

	public   void clickretailer() {

		Retailer.click();
		
	

	}

	public  void ClickAdmin() {

		Administration.click();
  
 
}
	
}
