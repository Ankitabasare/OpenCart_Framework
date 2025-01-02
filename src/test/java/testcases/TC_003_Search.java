package testcases;

import org.testng.annotations.Test;

import Pageobjects.SearchProduct;
import TestBase.BaseClass;

public class TC_003_Search extends BaseClass
{

	@Test
	public void verify_search() throws InterruptedException
	{
	SearchProduct sp=new SearchProduct(driver);
	sp.Seacrh("test");
	
	sp.ClickSearch();
	
	Thread.sleep(3000);
	sp.addWishList();
	
	Thread.sleep(3000);
	sp.Click_Add_to_cart();

	// String successMessage = sp.getSuccessMessage();
     //System.out.println("Captured Success Message: " + successMessage);
	
	sp.click_cart();
	}
}
