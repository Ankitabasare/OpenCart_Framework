package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement account;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
	WebElement login;
	
	public void clickMyaccount()
	{
		account.click();
	}
	public void clickRegister()
	{
		register.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
}



