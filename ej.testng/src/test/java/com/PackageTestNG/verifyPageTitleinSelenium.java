package com.PackageTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class verifyPageTitleinSelenium {
	
	WebDriver driver;
  @Test(description = "runing verify application title")
  public void verifyapplicationtitle() {
	  
	  System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");

		driver = new FirefoxDriver();
		driver.get("http://learn-automation.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String my_titile = driver.getTitle();
		Assert.assertTrue(my_titile.contains("Selenium WebDriver tutorial"));
		System.out.println("get titile succcessfulllyyy");
		
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
