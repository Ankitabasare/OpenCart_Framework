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
	
	Thread.sleep(5000);
	sp.addWishList();
	
	}
}
