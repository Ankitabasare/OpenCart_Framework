package Pageobjects;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage

{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);	
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath ="//input[@id='input-lastname']" )
	WebElement txtLastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	
	@FindBy(name = "agree" )
	WebElement policy;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmMsg;
	
	public void setFirstname(String firstname)
	{
		txtFirstname.sendKeys(firstname);
	}
	
	public void setLasttname(String lastname)
	{
		txtLastname.sendKeys(lastname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPassowrd(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickPolicy() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(policy));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", policy);
	        js.executeScript("arguments[0].click();", policy); // JavaScript click as fallback
	    } catch (Exception e) {
	        System.out.println("Error while clicking policy: " + e.getMessage());
	    }
	}

	
	public void clickContinue() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(btn_continue));
	        
	        // Scroll into view and click using JavaScript as a fallback
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", continueButton);
	        js.executeScript("arguments[0].click();", continueButton);
	    } catch (Exception e) {
	        System.out.println("Error while clicking continue button: " + e.getMessage());
	    }
	}

	
	public String getConfirmationMsg() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    wait.until(ExpectedConditions.visibilityOf(confirmMsg));
	    return confirmMsg.getText();
	}

	}



