package memberTab;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import base.TestBase;

public class memberSearchPage extends TestBase {
	
	@FindBy(xpath = "//*[@id='menu_section']//*[text()='Member Account']")
	WebElement MemberAccount;
	
	@FindBy(xpath = "//*[@id='menu_section']//*[@id='child_accountmanagement']//*[text()='Search']")
	WebElement MemberAccountSearch;
	
	@FindBy(xpath = "//form[@name='AccountSearchForm']//span")
	static
	List<WebElement> AccountSearchFields;
	
	@FindBy(xpath = "//form[@name='AccountSearchForm']//input[@type='text']")
	static
	List<WebElement> AccountSearchInputs;
	
	@FindBy(xpath = "//input[@class='searchButton']")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id='content']/div[@class='resultlist']/span")
	static
	WebElement resultCount;
	
	@FindBy(xpath = "//*[@id='row']/tbody/tr[1]/td[1]/a")
	static
	WebElement firstElement;
	
	@FindBy(xpath = "//*[@class='tab'][text()='Attributes']")
	static
	WebElement memberAttributesTab;
	
	@FindBy(xpath = "//*[@id='content']//*[@class='label-float-left'][contains(text(),'Partner')]")
	static
	List<WebElement> memberAttribute_partnerID;
	
	@FindBy(xpath = "//*[@id='content']//*[@class='label-float-right']")
	static
	List<WebElement> memberAttribute_partnerIDValue;
	
	
	
	
	
	//*[@id='content']//*[@class='label-float-right']
	
	
	
	
	public memberSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void memberSearchSelect()
	
	{
		
		MemberAccount.click();
		
		MemberAccountSearch.click();
		
	}
	public WebElement SearchInputElement(String inputField)

	{

		int i = 0;

		int searchInputIndex = 0;
		
		WebElement currentElement;

		for( i = 0; i<AccountSearchFields.size();i++)

		{

			if(AccountSearchFields.get(i).getText().contains(inputField))
			{
				searchInputIndex = i;

			}			
		}
		currentElement = AccountSearchInputs.get(searchInputIndex);

		return currentElement;

	}

	
	public void searchButtonClick()
	{
		
		searchButton.click();
		
	}
	
	public boolean resultCountDisplayVerification()
	{
		WebDriverWait wait = new WebDriverWait(driver, 200000);
		wait.until(ExpectedConditions.visibilityOf(resultCount));
		if(resultCount.isDisplayed())
		{
			System.out.println("Search operation successful -- Search result : " + resultCount.getText());
			ATUReports.setAuthorInfo("G10X", Utils.getCurrentTime(), "1.0");
			ATUReports.add("Search Result displayed", "MemberSearch", "NA", "NA", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		return true;
		}
		
		
		else
		{
			System.out.println("Search Result not displayed");
			ATUReports.setAuthorInfo("G10X", Utils.getCurrentTime(), "1.0");
			ATUReports.add("Search Result not displayed", "MemberSearch", "NA", "NA", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		return false;
		}
	}
	
	public void accountInputFieldsClear()
	{
		
		for(int i = 0;i<AccountSearchInputs.size();i++)
		{
			if(AccountSearchInputs.get(i)!=null)
			{
			AccountSearchInputs.get(i).clear();
			}
		}
	}
	
	
	public static int getMemberCountfromUI()
	
	
	{
		//Handline using Explicit wait since Performance issue is not fixed yet in Member search
		int displayedCount;
		WebDriverWait wait = new WebDriverWait(driver, 200000);
		wait.until(ExpectedConditions.visibilityOf(resultCount));
		
		String displayedCountMsg = resultCount.getText();
		
		String[] resultArray = displayedCountMsg.split(" ");
		
			String uiCountMsg = resultArray[0];
			
			if(uiCountMsg.equals("One"))
			{
				
				displayedCount = 1;
			}
			else
				
			{
				displayedCount = Integer.parseInt(uiCountMsg);
				
			}
			
			System.out.println("Count displayed in UI " + displayedCount);
		
		/*System.out.println("First value " + resultArray[0]);
		
		String numbersOnly= displayedCountMsg.replaceAll("[^0-9]", "");
				
		System.out.println(numbersOnly);
		 displayedCount = Integer.parseInt(numbersOnly);
		
		System.out.println("Count displayed in UI " + displayedCount);
		
		int value2 =0;
        
       
       
        int value3 = value2+ displayedCount;
        
        String gi ="one";
        boolean call = Pattern.matches("[a-zA-Z]{3}", "one");
        
        if(call==true){
             value2= 1;
             
        }
        else{
            
        }
        System.out.println(value2);*/
 
	
		
		return displayedCount;
		
	}
	
	public static String verifyMemberAttributes()
	{
		firstElement.click();
		
		String attributeValue = null;
		
		if(memberAttributesTab.isDisplayed())
		{
			
			memberAttributesTab.click();
			
			
			
			int i=0;
								
					if(memberAttribute_partnerIDValue.get(i).getText().isEmpty())
					{
						
						attributeValue = memberAttribute_partnerIDValue.get(i+1).getText();
						
					}
					
					else
					{
						
						attributeValue = memberAttribute_partnerIDValue.get(i).getText();
					}
				
			}
		
		return attributeValue;
		}
		
		
}
