package com.undostres.qa.pages;

import com.undostres.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends TestBase {
	@FindBy(id="first_name")
	WebElement firstName;

	// Timezone issue

	public AppointmentPage() {
		PageFactory.initElements(driver, this);
	}
}
