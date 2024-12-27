package Pageobjects;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath ="//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath ="(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
	WebElement lnkLogout;

	public boolean isMyAccountPageExists() throws InterruptedException   // MyAccount Page heading display status
	{
		Thread.sleep(5000);
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.elementToBeClickable(lnkLogout));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);",lnkLogout);
		        js.executeScript("arguments[0].click();", lnkLogout); // JavaScript click as fallback
		    } catch (Exception e) {
		        System.out.println("Error while clicking policy: " + e.getMessage());
		    }
		
	}
	
}
