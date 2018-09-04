package com.nisum.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nisum.qa.base.TestBase;

public class NisumProductDetailsPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	WebElement ButtonAddToCart;

	@FindBy(xpath = "//a[@id='anchor-btn-checkout']")
	WebElement checkoutbutton;

	public NisumProductDetailsPage()
	{

		PageFactory.initElements(driver, this);

	}

	public NisumShoppingCart NavigateToCheckoutPage() throws InterruptedException

	{
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");*/
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add to Cart')]")));
		/*
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return window.stop");*/
		
		try {
			
			if (ButtonAddToCart.isDisplayed()) {
				ButtonAddToCart.click();
				Thread.sleep(2000);
				checkoutbutton.click();
				
				
			}
			
		} catch (Exception e) {
			System.out.println("Page still loading .. Add To cart button not appearing on the page");
		}
		return new NisumShoppingCart();
		/*ButtonAddToCart.click();
		Thread.sleep(2000);
		checkoutbutton.click();
		return new NisumShoppingCart();*/

	}

}
