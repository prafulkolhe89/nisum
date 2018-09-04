package com.nisum.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nisum.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {

			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					"src\\main\\java\\com\\nisum\\qa\\config\\config.properties");
			prop.load(fs);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser_name = prop.getProperty("browser");

		if (browser_name.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\nisum\\qa\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser_name.equals("FireFox")) {
			System.setProperty("Webdriver.gecko.Driver", "path for firefox");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		/*driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);*/
		
		//This code was commented out to over come Time out receiving message from the renderer error.
	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		
		
		
		driver.get(prop.getProperty("url"));
	}

}
