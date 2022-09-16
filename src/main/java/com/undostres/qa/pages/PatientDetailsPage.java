package com.undostres.qa.pages;

import com.undostres.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PatientDetailsPage extends TestBase{

    @FindBy(className="PersonName-givenName")
    WebElement firstName;

    @FindBy(className="PersonName-familyName")
    WebElement familyName;

    @FindBy(className="PersonName-middleName")
    WebElement middleName;

    @FindBy(className="coreapps-telephoneNumber")
    WebElement phone;

    @FindBy(id="attachments.attachments.overallActions.default")
    WebElement attachment;

    @FindBy(id="org.openmrs.module.coreapps.deletePatient")
    WebElement deletePatient;

    @FindBy(xpath="//div[contains(@class,'gender-age')]/span")
    WebElement gender;

    @FindBy(id= "delete-reason")
    WebElement reason;

    @FindBy(id= "confirm")
    WebElement confirm;

    public WebElement getConfirm() {
        return confirm;
    }

    public PatientDetailsPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getFamilyName() {
        return familyName;
    }
    public WebElement getGender() {
        return gender;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getMiddleName() {
        return middleName;
    }

    public WebElement getAttachment() {
        return attachment;
    }

    public WebElement getDeletePatient() {
        return deletePatient;
    }
    public WebElement getReason() {
        return reason;
    }

}
