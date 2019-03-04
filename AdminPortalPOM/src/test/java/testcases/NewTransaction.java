package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import adminportalpages.adminportal_HomePage;
import base.TestBase;
import transactionTab.NewTransactionPage;

public class NewTransaction extends TestBase {
	
	adminportal_HomePage adminportalhomepage;

	NewTransactionPage newtransactionpage;

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialization();

		adminportalhomepage = new adminportal_HomePage();

		newtransactionpage = new NewTransactionPage();

	}

	@Test(priority = 1)


	public void newrewardtransaction() throws InterruptedException {

		adminportalhomepage.clickTransaction();

		Thread.sleep(3000);

		newtransactionpage.newtransaction();
		newtransactionpage.rewardtransaction();

	}

	@Test(priority = 2)
	public void newpurchasebalancetransaction() throws InterruptedException {

		adminportalhomepage.clickTransaction();
		Thread.sleep(3000);
		newtransactionpage.newtransaction();
		newtransactionpage.pbtransaction();

	}

	@Test(priority = 3)
	public void itemdetailtransaction() throws InterruptedException {

		adminportalhomepage.clickTransaction();
		Thread.sleep(3000);
		newtransactionpage.newtransaction();
		newtransactionpage.itemdetailtransaction();

	}

	@AfterMethod

	public void quit() {

		driver.close();
	}

}
