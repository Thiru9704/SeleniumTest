package com.undostres.qa.testcases;

import com.undostres.qa.base.TestBase;
import com.undostres.qa.pages.HomePage;
import com.undostres.qa.pages.LoginPage;
import com.undostres.qa.pages.PatientsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class PatientSearchTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	PatientsPage patientsPage;

	public PatientSearchTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login successful");
		patientsPage = homePage.clickOnFindPatientLink();
	}
	
	@Test(priority=1)
	public void searchPatient() throws InterruptedException {
		String patientId = "Gunji";
		WebElement search = patientsPage.getPatientSearch();
		search.sendKeys("");
		patientsPage.patientSearch(patientId);
		Thread.sleep(1000);
		WebElement table =patientsPage.getResultsTable();
		WebElement tBody = table.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = tBody.findElements(By.tagName("tr"));

		for (WebElement row : tableRows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			Assert.assertEquals(cols.get(0).getText(),patientId+"Recent" );
		}
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
