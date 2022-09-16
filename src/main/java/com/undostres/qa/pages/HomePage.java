package com.undostres.qa.pages;

import com.undostres.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

	@FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
	@CacheLookup
	WebElement registerPatient;

	@FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	WebElement findPatient;
	
	@FindBy(id = "appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")
	WebElement appointment;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public PatientsPage clickOnFindPatientLink(){
		findPatient.click();
		return new PatientsPage();
	}
	
	public PatientRegistrationPage clickOnRegisterPatientLink(){
		registerPatient.click();
		return new PatientRegistrationPage();
	}
	
	public AppointmentPage clickOnAppointmentLink(){
		appointment.click();
		return new AppointmentPage();
	}

	public LoginPage clickOnLogoutButton(){
		logout.click();
		return new LoginPage();
	}
}
