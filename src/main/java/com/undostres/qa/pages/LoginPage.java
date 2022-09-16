package com.undostres.qa.pages;

import com.undostres.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="Inpatient Ward")
	WebElement ipWard;

	@FindBy(id="loginButton")
	WebElement loginBtn;
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		ipWard.click();
		loginBtn.click();
		return new HomePage();
	}
}
