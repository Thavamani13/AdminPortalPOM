package memberTab;

import java.util.List;

import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath = "//form[@name='AccountSearchForm']//input[@type='text']")
	static
	List<WebElement> AccountSearchInputs;
	
	@FindBy(xpath = "//input[@class='searchButton']")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id='content']/div[@class='resultlist']/span")
	WebElement resultCount;
	
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
	
	public void resultCountDisplayVerification()
	{
		
		if(resultCount.isDisplayed())
		{
			System.out.println("Search operation successful -- Search result : " + resultCount.getText());
		}
		
		else
		{
			System.out.println("Search Result not displayed");
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
	
	
}
