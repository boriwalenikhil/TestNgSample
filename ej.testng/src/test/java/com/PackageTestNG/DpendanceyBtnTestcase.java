package com.PackageTestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DpendanceyBtnTestcase {

	WebDriver driver;
@BeforeClass
	public void Browserstart() {
	System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");

	driver = new FirefoxDriver();
	
	System.out.println("********** Browser Started *************");

	}
	
	
	@Test
	public void startApp() throws InterruptedException {
		

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentlurl = driver.getCurrentUrl();
		// check website is loaded is correct or not
		Assert.assertTrue(currentlurl.contains("opensource-demo.orangehrmlive.com"));
		System.out.println("application loaded");

	}

	@Test(dependsOnMethods = "startApp")
	public void loginApp() {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		System.out.println("login to app");

		// check is i am on user login page successfully or not
		boolean status = driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).isDisplayed();
		Assert.assertTrue(status);
	}

	@Test(dependsOnMethods = "loginApp")
	public void logoutApp() throws InterruptedException  {
		
		WebElement element = driver.findElement(By.xpath("//a[@id='welcome']"));
		WebDriverWait wait = new WebDriverWait(driver, 30); //here, wait time is 20 sec
		wait.until(ExpectedConditions.visibilityOf(element)); //this will wait for element to be visible for 20 seconds
		element.click(); //now it clicks on element
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

		/// check logout successfully via assert true condition
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='txtUsername']")).isDisplayed());
		System.out.println("logout to app");

	}

	@AfterClass
	public void closeapp() {
		System.out.println("********** Browser Close *************");

		driver.quit();
		
		
	}
	
	
}
