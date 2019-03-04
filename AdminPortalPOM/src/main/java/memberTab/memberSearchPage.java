package memberTab;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class memberSearchPage extends TestBase {
	
	@FindBy(xpath = "//*[@id='menu_section']//*[text()='Member Account']")
	WebElement MemberAccount;
	
	@FindBy(xpath = "//*[@id='menu_section']//*[@id='child_accountmanagement']//*[text()='Search']")
	WebElement MemberAccountSearch;
	
	@FindBy(xpath = "//form[@name='AccountSearchForm']//span")
	static
	List<WebElement> AccountSearchFields;
	
	@FindBy(xpath = "//form[@name='AccountSearchForm']//input")
	static
	List<WebElement> AccountSearchInputs;
	
	public memberSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public static void SearchInput(String inputField,String inputValue)
	
	{
		
		int i = 0;
		
		int searchInputIndex = 0;
		
		for( i = 0; i<AccountSearchFields.size();i++)
			
		{
			
		if(AccountSearchFields.get(i).getText().contains(inputField))
			
			{
				
				searchInputIndex = i;
								
				
			}
		
			
		}
		
		
		AccountSearchInputs.get(searchInputIndex).sendKeys(inputValue);
		
	}

}
