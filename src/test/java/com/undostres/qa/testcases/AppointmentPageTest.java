package com.undostres.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.undostres.qa.base.TestBase;
import com.undostres.qa.pages.AppointmentPage;
import com.undostres.qa.pages.HomePage;
import com.undostres.qa.pages.LoginPage;

public class AppointmentPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    AppointmentPage appointmentPage;

    public AppointmentPageTest(){
        super();
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        System.out.println("login successful");
        appointmentPage = homePage.clickOnAppointmentLink();
    }

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
