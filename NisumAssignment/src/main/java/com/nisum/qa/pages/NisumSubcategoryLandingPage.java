package com.nisum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.qa.base.TestBase;

public class NisumSubcategoryLandingPage extends TestBase {

	@FindBy(xpath = "(//span[@class='product-thumb-casing'])[1]")
	WebElement FirstProduct;

	@FindBy(xpath="(//a[@class='product-name'])[1]")
	WebElement NameOfProduct;
	
	@FindBy(xpath="//a[@title='Minimize']")
	WebElement PromoWindowDeleteButton;
	
	
	
	public NisumSubcategoryLandingPage()

	{

		PageFactory.initElements(driver, this);

	}
	public void Minimizepromo() 
	{
		
		try {
			if (PromoWindowDeleteButton.isDisplayed()) 
			{
				PromoWindowDeleteButton.click();
			}
		} catch (Exception e) {
			System.out.println("Promotion window did not appaer");
		}		 
	}
	
	

	public NisumProductDetailsPage ClickonProduct()

	{

		FirstProduct.click();

		return new NisumProductDetailsPage();

	}
	
	public String NameOfProduct() 
	{
		return NameOfProduct.getText();
	}

}
