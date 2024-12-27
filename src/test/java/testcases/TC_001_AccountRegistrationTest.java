package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.AccountRegistrationPage;
import Pageobjects.HomePage;
import TestBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	@Test(groups = {"regression","Master"})
	void verify_account_registration()
	{
		logger.info("************Starting TC_001AccountRegistrationTest");
		try {
		HomePage home=new HomePage(driver);
		home.clickMyaccount();
		logger.info("Clicked on MyAccount Link");
		
		home.clickRegister();
		logger.info("Clicked on Registration Link");
		
		AccountRegistrationPage asp=new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details.....");
		
		asp.setFirstname(randomString().toUpperCase().toUpperCase());
		asp.setLasttname(randomString());
		asp.setEmail(randomString()+"@gmail.com");
		asp.setPassowrd(randomAlphanumber());
		
		asp.clickPolicy();
		asp.clickContinue();
		
		logger.info("Validating expected message...");
		
		
		String confmsg=asp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch (Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		logger.info("Finished TC_001AccountRegistrationTest");
	}
	
}
