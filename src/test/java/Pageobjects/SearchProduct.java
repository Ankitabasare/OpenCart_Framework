package Pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	@FindBy(xpath = "//i[@class='fa-solid fa-shopping-cart']")
	WebElement add_to_cart;
	
	//@FindBy(css = ".alert.alert-success")
	//WebElement message;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-inverse btn-block dropdown-toggle aad_button']")
	WebElement check_cart;
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
		        System.out.println("Error while clicking WishList: " + e.getMessage());
		    }
	}
	
	public void Click_Add_to_cart()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.elementToBeClickable(add_to_cart));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);",add_to_cart);
		        js.executeScript("arguments[0].click();", add_to_cart); // JavaScript click as fallback
		    } catch (Exception e) {
		        System.out.println("Error while clicking Add to cart " + e.getMessage());
		    }
	}
	
	/*public String getSuccessMessage() {
        return message.getText();
    } */
	
	public void click_cart()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.elementToBeClickable(check_cart));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);",check_cart);
		        js.executeScript("arguments[0].click();", check_cart); // JavaScript click as fallback
		    } catch (Exception e) {
		        System.out.println("Error while clicking Add to cart " + e.getMessage());
		    }
	}
}
