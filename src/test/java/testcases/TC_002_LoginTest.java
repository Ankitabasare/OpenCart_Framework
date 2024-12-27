package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.HomePage;
import Pageobjects.LoginPage;
import Pageobjects.MyAccountPage;
import TestBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		try
		{
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on myaccount link on the home page..");
		hp.clickLogin(); //Login link under MyAccount
		logger.info("clicked on login link under myaccount..");
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(pop.getProperty("email"));
		lp.setPassword(pop.getProperty("password"));
		lp.clickLogin(); //Login button
		logger.info("clicked on ligin button..");
		
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
		
		Thread.sleep(50000);
		boolean targetPage=macc.isMyAccountPageExists();
		
		System.out.println(targetPage);
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
	}
}
