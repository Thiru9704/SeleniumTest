package com.undostres.qa.testcases;

import com.undostres.qa.pages.PatientRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.*;

import com.undostres.qa.base.TestBase;
import com.undostres.qa.pages.HomePage;
import com.undostres.qa.pages.LoginPage;

public class PatientRegistrationPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	PatientRegistrationPage registrationPage;

	public PatientRegistrationPageTest(){
			super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login successful");
		registrationPage = homePage.clickOnRegisterPatientLink();
	}
	
//	@Test(priority=1)
//	public void verifyRegistrationPageLabel(){
//		Assert.assertEquals(registrationPage.getPageTitle().getText(), "Register a patient");
//	}
	
	@Test
	public void validateCreateNewContact(){
		String firstName = "Thiru";
		String middleName = "pathi";
		String familyName= "Gunji";
		String gender = "M";
		String years = "30";
		String months = "1";
		String address = "India";
		String address1 = "karnataka";
		String city = "Bangalore";
		String state = "Karnataka";
		String country = "India";
		String postal = "56001";
		String phone = "123";
		String relation = "Sibling";
		String person = "anji";

		registrationPage.registerPatient(firstName, middleName, familyName, gender, years, months, address,address1,
				city,state,country, postal, phone, relation, person);
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
