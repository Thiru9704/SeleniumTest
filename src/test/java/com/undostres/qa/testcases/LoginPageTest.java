package com.undostres.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.undostres.qa.base.TestBase;
import com.undostres.qa.pages.HomePage;
import com.undostres.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
	}

	@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
