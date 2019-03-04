package transactionpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;

import base.TestBase;

public class NewTransactionPage  extends TestBase{
	
	
	//WebDriverWait wd = new WebDriverWait(driver, 20);
	
	
	//00012000013812
	
	
	
	@FindBy(xpath = "//a[text()='Transactions']")
	WebElement Transactions;
	
	
	@FindBy(xpath = "//a[text()='Search'][1]")
	WebElement SearchTransaction;
	
	@FindBy(xpath = "//a[text()='New'][1]")
	WebElement NewTransaction;
	
	
	@FindBy(xpath = "//input[@name='accountId']")
	WebElement loyaltyid;
	
	
	@FindBy(xpath = "//select[@name='participantId']")
	WebElement participantId;
	
	@FindBy(xpath = "//select[@name='siteId']")
	WebElement siteId;
	
	
	@FindBy(xpath = "//select[@name='adjustmentTypeId']")
	WebElement adjustmentTypeId;
	
	@FindBy(xpath = "//select[@name='reasonCodeId']")
	WebElement reasonCodeId;
	
	
	@FindBy(xpath = "//input[@value='  NEXT  ']")
	WebElement NEXT;
	
	@FindBy(xpath = "//input[@name='amount']")
	WebElement amountvalue;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	
	
	@FindBy(xpath = "//div[@class='success-msg divider']")
	WebElement successmessage;
	
	
	@FindBy(xpath = "//option[text()=\"Rewards\"]]")
	WebElement Rewards;
	
	
	@FindBy(xpath = "//option[text()=\"Discount was not issued\"]]")
	WebElement reasoncodevalue;
	
	@FindBy(xpath = "//select[@name='itemType']")
	WebElement productType;
	
	@FindBy(xpath = "//input[@name='itemCode']")
	WebElement productid;
	
	
	@FindBy(xpath = "//input[@name='itemDeptNo']")
	WebElement Dept;
	
	
	@FindBy(xpath = "//select[@name='itemType']")
	WebElement unit;
	
	
	@FindBy(xpath = "//input[@name='units']")
	WebElement QTY;
	
	@FindBy(xpath = "//input[@name='itemPrice']")
	WebElement price;
	
	@FindBy(xpath = "//input[@name='btnActionAdd']")
	WebElement ADDBUTTON;
	
	
	@FindBy(xpath = "//select[@name='unitType']")
	WebElement unitType;

	
	

	
	
	
	
	
	
	
	
	public NewTransactionPage() {
		PageFactory.initElements(driver, this);
	}



	public void searchtransaction() {
		
		
		Transactions.click();
		
		SearchTransaction.click();
		
		
		
	}
	
	public void newtransaction() throws InterruptedException {
		
        // driver.findElement(By.xpath("//a[text()='Transactions']")).click();
		Transactions.click();
         
         Thread.sleep(2000);
		
       //  driver.findElement(By.xpath("//a[text()='New'][1]")).click();
         
         NewTransaction.click();
		
		
	}
	
	
	
	
	public void rewardtransaction() throws InterruptedException {
		
		
		loyaltyid.sendKeys(prop.getProperty("loyalid_rewardtransaction"));
		
		Select particpantid = new Select(participantId);
		particpantid.selectByVisibleText("tmurugan_part1 - tmurugan_part1");
		
		
		Select siteid = new Select(siteId);
		siteid.selectByVisibleText("tmurugan_part1_site4 - tmurugan_part1_site4");
		
		
		

		Select Transactiontype = new Select(adjustmentTypeId);
		Transactiontype.selectByVisibleText("Rewards");
		//wd.until(ExpectedConditions.elementToBeSelected(Rewards));

		
		
		Select reasoncode = new Select(reasonCodeId);
		reasoncode.selectByVisibleText("Discount was not issued");
	//	wd.until(ExpectedConditions.elementToBeSelected(reasoncodevalue));

		
		NEXT.click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		amountvalue.sendKeys("0.10");
		NEXT.click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		submit.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		String text = successmessage.getText();
		System.out.println(text);
		
		String refernecid= text.replaceAll("[^0-9]", "");
		System.out.println("Reward Ajustment Reference Id  "  +refernecid );

	}
	
	
	public void pbtransaction() {
		
		loyaltyid.sendKeys("1001");
		
		Select particpantid = new Select(participantId);
		particpantid.selectByVisibleText("tmurugan_part6 - tmurugan_part6");
		
		
		Select siteid = new Select(siteId);
		siteid.selectByVisibleText("tmuruganpart6_site1 - tmuruganpart6_site1");
		
		
		Select Transactiontype = new Select(adjustmentTypeId);
		Transactiontype.selectByVisibleText("Purchase Balance");
		
		
		Select reasoncode = new Select(reasonCodeId);
		reasoncode.selectByVisibleText("Loyalty card was not present");
		
	    NEXT.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		amountvalue.sendKeys("0.15");
		NEXT.click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		submit.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		String text = successmessage.getText();
		System.out.println(text);
		
		String refernecid= text.replaceAll("[^0-9]", "");
		System.out.println("PurchaseBalance Ajustment Reference Id  "  +refernecid );
		
		
	}
	
	
	
	
	public void itemdetailtransaction() {
		
		
        loyaltyid.sendKeys("1001");
		
		Select particpantid = new Select(participantId);
		particpantid.selectByVisibleText("tmurugan_part6 - tmurugan_part6");
		
		
		Select siteid = new Select(siteId);
		siteid.selectByVisibleText("tmuruganpart6_site1 - tmuruganpart6_site1");
		
		
		Select Transactiontype = new Select(adjustmentTypeId);
		Transactiontype.selectByVisibleText("Product Detail");
		
		
		Select reasoncode = new Select(reasonCodeId);
		reasoncode.selectByVisibleText("Site Certification/Testing");
		
	    NEXT.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		Select prodtype = new Select(productType);
		prodtype.selectByVisibleText("UPC");
		
		productid.sendKeys("00012000013812");
		
		Select units = new Select(unitType);
		units.selectByVisibleText("Count");
		
		QTY.sendKeys("2");
		
		price.sendKeys("5");
		
	    ADDBUTTON.click();
	    
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		NEXT.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		submit.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		String text = successmessage.getText();
		System.out.println(text);
		
		String refernecid= text.replaceAll("[^0-9]", "");
		System.out.println("PurchaseBalance Ajustment Reference Id  "  +refernecid );


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




}
