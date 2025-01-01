package Pageobjects;

import java.sql.Driver;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct extends BasePage
{

	public SearchProduct(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "search")
	WebElement seacrh_bar;
	
	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
	WebElement click_seacrh;
	
	@FindBy(xpath = "//button[@aria-label='Add to Wish List']//i[@class='fa-solid fa-heart']")
	WebElement wishList;
	public void Seacrh(String string)
	{
		seacrh_bar.sendKeys(string);
	}
	public void ClickSearch()
	{
		click_seacrh.click();
	}
	
	public void addWishList()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.elementToBeClickable(wishList));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);",wishList);
		        js.executeScript("arguments[0].click();", wishList); // JavaScript click as fallback
		    } catch (Exception e) {
		        System.out.println("Error while clicking policy: " + e.getMessage());
		    }
	}
	
	
}
