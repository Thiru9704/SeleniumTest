package com.undostres.qa.testcases;

import com.undostres.qa.base.TestBase;
import com.undostres.qa.pages.HomePage;
import com.undostres.qa.pages.LoginPage;
import com.undostres.qa.pages.PatientDetailsPage;
import com.undostres.qa.pages.PatientsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class LogoutTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	PatientsPage patientsPage;

	public LogoutTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login successful");
	}

	//  href="/openmrs/appui/header/logout.action?successUrl=openmrs"
	@Test(priority=1)
	public void logoutFromWebsite() throws InterruptedException {

	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
