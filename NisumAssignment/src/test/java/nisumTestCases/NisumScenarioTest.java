package nisumTestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nisum.qa.base.TestBase;
import com.nisum.qa.pages.NisumCategoryLandingPage;
import com.nisum.qa.pages.NisumHomePage;
import com.nisum.qa.pages.NisumProductDetailsPage;
import com.nisum.qa.pages.NisumShoppingCart;
import com.nisum.qa.pages.NisumSubcategoryLandingPage;

public class NisumScenarioTest extends TestBase {

	NisumHomePage NisumHomePageObj;

	NisumCategoryLandingPage NisumCategoryLandingPageOBj;

	NisumProductDetailsPage NisumProductDetailsPageObj;

	NisumShoppingCart NisumShoppingCartObj;

	NisumSubcategoryLandingPage NisumSubcategoryLandingPageObj;

	public NisumScenarioTest(){

		super();

	}

	@BeforeMethod
	public void setuup() throws InterruptedException {
		initialization();
	}

	

	@Test
	public void Scenario() throws InterruptedException
	{
		NisumHomePageObj=new NisumHomePage();
		NisumSubcategoryLandingPageObj = new NisumSubcategoryLandingPage();
		NisumProductDetailsPageObj = new NisumProductDetailsPage();
		NisumShoppingCartObj = new NisumShoppingCart();
		
		NisumHomePageObj.HoverOnMainCategory();		
		NisumSubcategoryLandingPageObj.Minimizepromo();
		String ProductName = NisumSubcategoryLandingPageObj.NameOfProduct();		
		NisumSubcategoryLandingPageObj.ClickonProduct();
		System.out.println(ProductName);
		NisumProductDetailsPageObj.NavigateToCheckoutPage();
		System.out.println(driver.getTitle());
		
		NisumShoppingCartObj.saveCartForLater();
		String SavedProduct = NisumShoppingCartObj.SavedProductName();
		
		Assert.assertTrue(ProductName.equals(SavedProduct));
		
		if (ProductName.equalsIgnoreCase(SavedProduct)) {
			System.out.println("Test case has passed");
		} else {
			
			System.out.println("Test case failed");

		}
		
		
		/*
		 * NisumHomePageObj.NavigateTosubCategoryPage();
		 * 
		 * NisumSubcategoryLandingPageObj.ClickonProduct();
		 * 
		 * NisumProductDetailsPageObj.NavigateToCheckoutPage();
		 * 
		 * NisumShoppingCartObj.saveCartForLater();
		 */

	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();

	}

}
