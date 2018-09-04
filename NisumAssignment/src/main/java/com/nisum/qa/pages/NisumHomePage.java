package com.nisum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.qa.base.TestBase;

public class NisumHomePage extends TestBase {

	@FindBy(linkText = "Cookware")
	WebElement MainCategory;

	@FindBy(linkText = "Tea Kettles")
	WebElement TeaKettleSubCategory;

	public NisumHomePage()
	{

		PageFactory.initElements(driver, this);
	}

	public void HoverOnMainCategory() throws InterruptedException
	{
		
		System.out.println("in method hover");

		Actions action = new Actions(driver);

		action.moveToElement(MainCategory).build().perform();
		/*
		 * TestUtil.Hoveronelement(MainCategory); 
		 */
		Thread.sleep(2000);
		
		TeaKettleSubCategory.click();
		
		

	}

}
