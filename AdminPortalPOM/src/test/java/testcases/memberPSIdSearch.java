package testcases;

import java.io.IOException;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import adminportalpages.adminportal_HomePage;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import base.TestBase;
import base.pathInterface;
import jxl.read.biff.BiffException;
import memberTab.memberSearchPage;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
    MethodListener.class })
public class memberPSIdSearch extends TestBase {



public memberPSIdSearch() {
	
	super();
}
	{
	    System.setProperty("atu.reporter.config", pathInterface.atuPropertiesPath);
	    
	}
	
	static String input_email="Email";
	static String input_memberaltid="Member ALT ID";
	static String input_phone="Phone";
	static String input_firstname="First Name";
	static String input_lastname="Last Name";
	static String input_fpaccountid="Account ID";
	static String input_partnermemberid="Partner Member ID";
	static String input_partnersourceid="Partner Source ID";
	static String psIDSheet="QA_PSID";
	static String v2IDSheet="QA_V2ID";
	
	
	
	adminportal_HomePage adminportalhomepage;
	
	memberSearchPage membersearchpage;
	
	@BeforeClass
	
	public void setup() throws InterruptedException, BiffException, IOException
	{
		initialization();
		
		adminportalhomepage = new adminportal_HomePage();
		
		membersearchpage = new memberSearchPage();
		
		//TestBase.mapassign();
		
		
	}

	//Search By Partner Member ID and validating the count by comparing with DB
	@Test(priority=1)
	
	public void psIDSearch_tc01() throws Exception
	{				
		
		adminportalhomepage.clickmember();		
		membersearchpage.memberSearchSelect();		
		WebElement element = membersearchpage.SearchInputElement(input_partnersourceid);
		TestBase.sendKeys(element, getCellData(psIDSheet, 0, 0));
		membersearchpage.searchButtonClick();		
		int DBCount = TestBase.TestpartnerSourceId_DB(TestBase.getCellData(psIDSheet, 0, 0));		
		int UICount = memberSearchPage.getMemberCountfromUI();
		TestBase.compareResults(DBCount, UICount);
			
		
	}
	//Search By Partner Member ID using Keyboard Enter and validating the count by comparing with DB
	@Test(priority=2)
	
	public void psIDSearch_tc02() throws Exception
	{				
		membersearchpage.accountInputFieldsClear();		
		Thread.sleep(2000);
		WebElement element = membersearchpage.SearchInputElement(input_partnersourceid);			
		TestBase.sendKeys(element, getCellData(psIDSheet, 0, 1));		
		TestBase.keysEnter(element);		
		int DBCount = TestBase.TestpartnerSourceId_DB(TestBase.getCellData(psIDSheet, 0, 1));
		int UICount = memberSearchPage.getMemberCountfromUI();
		TestBase.compareResults(DBCount, UICount);
						
	}
	//Search By partner Source ID and multiple other fields and comparing the results
	@Test(priority=3)
	
	public void psIDSearch_tc03() throws Exception
	{				
		membersearchpage.accountInputFieldsClear();		
		Thread.sleep(2000);
		WebElement psid = membersearchpage.SearchInputElement(input_partnersourceid);			
		TestBase.sendKeys(psid, TestBase.getCellData(psIDSheet, 0, 3));
		WebElement altid = membersearchpage.SearchInputElement(input_memberaltid);			
		TestBase.sendKeys(altid, TestBase.getCellData(psIDSheet, 0, 4));
		WebElement fpaccountid = membersearchpage.SearchInputElement(input_fpaccountid);			
		TestBase.sendKeys(fpaccountid, TestBase.getCellData(psIDSheet, 0, 5));
		membersearchpage.searchButtonClick();					
		int DBCount = TestBase.TestpartnerSourceId_DB(TestBase.getCellData(psIDSheet, 0, 2));
		int UICount = memberSearchPage.getMemberCountfromUI();
		TestBase.compareResults(DBCount, UICount);
	}
	
	//Search By partner Source ID and verifying the correctness using values displayed under member Attributes
	@Test(priority=4)
	
	public void psIDSearch_tc04() throws Exception
	{				
		
		membersearchpage.accountInputFieldsClear();		
		Thread.sleep(2000);
		WebElement element = membersearchpage.SearchInputElement(input_partnersourceid);
		String desiredInput = getCellData(psIDSheet, 0, 0);
		TestBase.sendKeys(element, desiredInput);
		membersearchpage.searchButtonClick();
		String attributeValue = memberSearchPage.verifyMemberAttributes();		
		compareStrings(desiredInput,attributeValue);
		
	}
	


}
