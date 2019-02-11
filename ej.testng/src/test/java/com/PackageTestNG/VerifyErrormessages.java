package com.PackageTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VerifyErrormessages {
	WebDriver driver;

	@Test(priority =1,description = "check testcase using GETTEXT() to detect Error Message")
	public void errormessageWithGETTEXTMetod() {

		System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");

		driver = new FirefoxDriver();
		driver.get(
				"https://login.yahoo.com/config/login?.src=fpctx&.intl=in&.lang=en-IN&.done=https%3A%2F%2Fin.yahoo.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-signin']")).click();

		String Actual_error = driver.findElement(By.xpath("//p[@data-error='messages.ERROR_INVALID_USERNAME']"))
				.getText();

		// 1. check Partial
		Assert.assertTrue(Actual_error.contains("Sorry, we don't recognise this email address."));

		System.out.println("Run successfully with get text");

		// 2 assert equales method
	//	String Expected = "Sorry, we don't recognise this email address.";
	//	Assert.assertEquals(Actual_error, Expected);

		driver.quit();

	}
	
	@Test(priority= -2, description = "check testcase using GETATTRIBUTE() to detect Error Message")
	public void  errormessageWithGetAttribute() {
		
		
	/*	System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");

		driver = new FirefoxDriver();
		driver.get(
				"https://login.yahoo.com/config/login?.src=fpctx&.intl=in&.lang=en-IN&.done=https%3A%2F%2Fin.yahoo.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-signin']")).click();

		String Actual_error = driver.findElement(By.xpath("//p[@data-error='messages.ERROR_INVALID_USERNAME']"))
				.getAttribute("innerHTML");
		String Expected = "Sorry, we don't recognise this email address.";

		// 1. check Partial
		Assert.assertTrue(Actual_error.contains("Sorry, we don't recognise this email address."));
		System.out.println("Run successfully with get attribute");

		// 2 assert equales method
		//Assert.assertEquals(Actual_error, Expected);

		driver.quit();

		*/
		
	}
	
	
	

}
