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

public class PatientViewTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	PatientsPage patientsPage;

	public PatientViewTest(){
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
		List<WebElement> cols = tableRows.get(0).findElements(By.tagName("td"));
		PatientDetailsPage patientDetailsPage = patientsPage.getPatientDetailsPage(cols.get(0));
		Thread.sleep(3000);

		Assert.assertEquals(patientDetailsPage.getFamilyName().getText(),"Gunji" );
		Assert.assertEquals(patientDetailsPage.getFirstName().getText(),"Thiru" );
		Assert.assertEquals(patientDetailsPage.getGender().getText(),"Male" );
		Assert.assertEquals(patientDetailsPage.getMiddleName().getText(),"Pathi" );
	}

	@Test(priority=2)
	public void addAttachment() throws InterruptedException {
		String patientId = "Gunji";
		WebElement search = patientsPage.getPatientSearch();
		search.sendKeys("");
		patientsPage.patientSearch(patientId);
		Thread.sleep(1000);
		WebElement table =patientsPage.getResultsTable();
		WebElement tBody = table.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = tBody.findElements(By.tagName("tr"));
		List<WebElement> cols = tableRows.get(0).findElements(By.tagName("td"));
		PatientDetailsPage patientDetailsPage = patientsPage.getPatientDetailsPage(cols.get(0));
		Thread.sleep(3000);
		patientDetailsPage.getAttachment().click();
		Thread.sleep(3000);
		System.out.println("Disabled right now");
		patientDetailsPage.getFirstName().click();
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void deletePatient() throws InterruptedException {

		String patientId = "Gunji";
		WebElement search = patientsPage.getPatientSearch();
		search.sendKeys("");
		patientsPage.patientSearch(patientId);
		Thread.sleep(1000);
		WebElement table =patientsPage.getResultsTable();
		WebElement tBody = table.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = tBody.findElements(By.tagName("tr"));
		List<WebElement> cols = tableRows.get(0).findElements(By.tagName("td"));
		PatientDetailsPage patientDetailsPage = patientsPage.getPatientDetailsPage(cols.get(0));
		Thread.sleep(3000);
		patientDetailsPage.getDeletePatient().click();
		patientDetailsPage.getReason().sendKeys("Test");
		patientDetailsPage.getConfirm().click();
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
