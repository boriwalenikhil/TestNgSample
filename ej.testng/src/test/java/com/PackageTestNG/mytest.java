package com.PackageTestNG;

import org.testng.annotations.Test;

public class mytest {

	@Test(priority =1,description="this test case for login application")
public void loginApplication() {
	
	System.out.println("login ");
	
}
@Test(priority =2,description="this test case for select item")
	public void Selecteditem() {
		
	System.out.println("method Selecteditem  ");

	}

@Test(priority =3,description="this test case for checkout")
public void checkout() {
	System.out.println("method checkout");

	
}
public static void main(String[] args) {
	
}


}
