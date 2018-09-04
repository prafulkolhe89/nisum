package com.nisum.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.qa.base.TestBase;

public class NisumShoppingCart extends TestBase {

	 @FindBy(xpath="//a[@name='updates[0].moveToSFL']")

     WebElement SaveForLaterlink;

    

     public NisumShoppingCart()

     {

                     PageFactory.initElements(driver, this);

     }



     public void saveCartForLater()

     {

    	 SaveForLaterlink.click();

     }
     
     public String SavedProductName(){
    	 
    	  return driver.findElement(By.xpath("//div[@class='cart-table-row-title']")).getText();
     }
	
	
	
}
