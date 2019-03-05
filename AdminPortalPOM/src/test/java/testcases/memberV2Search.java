package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import adminportalpages.adminportal_HomePage;
import base.TestBase;
import memberTab.memberSearchPage;

public class memberV2Search extends TestBase {
	
	static String input_email = "Email";
	static String input_memberaltid = "Member ALT ID";
	static String input_phone = "Phone";
	static String input_firstname = "First Name";
	static String input_lastname = "Last Name";
	static String input_fpaccountid = "Account ID";
	
	adminportal_HomePage adminportalhomepage;
	
	memberSearchPage membersearchpage;
	
	@BeforeClass
	
	public void setup() throws InterruptedException
	{
		initialization();
		
		adminportalhomepage = new adminportal_HomePage();
		
		membersearchpage = new memberSearchPage();
		
		
	}

	
	@Test(priority=1)
	
	public void v2MemberSearch_tc01()
	{				
		adminportalhomepage.clickmember();		
		membersearchpage.memberSearchSelect();		
		WebElement element = membersearchpage.SearchInputElement(input_firstname);
		TestBase.sendKeys(element, "Praveen");
		membersearchpage.searchButtonClick();		
		membersearchpage.resultCountDisplayVerification();
		
		
	}
	
	@Test(priority=2)
	
	public void v2MemberSearch_tc02() throws InterruptedException
	{				
		membersearchpage.accountInputFieldsClear();
		
		Thread.sleep(2000);
		WebElement element = membersearchpage.SearchInputElement(input_email);			
		TestBase.sendKeys(element, "tmurugan@excentus.com");
		TestBase.keysEnter(element);		
		membersearchpage.resultCountDisplayVerification();				
	}
}
