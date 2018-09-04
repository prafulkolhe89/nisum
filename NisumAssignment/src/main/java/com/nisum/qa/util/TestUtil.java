package com.nisum.qa.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.nisum.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Page_load_timeout = 60;
	public static long implicit_wait = 20;

	public void switchtoframe() {

		driver.switchTo().frame("mainpanel");
	}

	public static void Hoveronelement(WebElement element)

	{

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

	}

}
