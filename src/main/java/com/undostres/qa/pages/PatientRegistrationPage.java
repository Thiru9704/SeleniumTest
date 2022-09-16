package com.undostres.qa.pages;

import com.undostres.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PatientRegistrationPage extends TestBase{

    @FindBy(name="givenName")
    WebElement firstName;

    @FindBy(name="familyName")
    WebElement familyName;

    @FindBy(name="middleName")
    WebElement middlename;

    @FindBy(id="next-button")
    WebElement next;

    @FindBy(className = "icon-chevron-right")
    WebElement pageTitle;

    public PatientRegistrationPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getNext() {
        return next;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getFamilyName() {
        return familyName;
    }

    public WebElement getMiddlename() {
        return middlename;
    }

    public WebElement getSubmit() {
        return next;
    }

    public WebElement getPatientGender(){
         return driver.findElement(By.id("gender-field"));
        //Select selectObject = new Select(selectElement);
    }

    public WebElement getEstimatedYearsField(){
        return driver.findElement(By.id("birthdateYears-field"));
    }

    public WebElement getEstimatedMonthsField(){
        return driver.findElement(By.id("birthdateMonths-field"));
    }

    public WebElement getAddress1Field(){
        return driver.findElement(By.id("address1"));
    }

    public WebElement getAddress2Field(){
        return driver.findElement(By.id("address2"));
    }

    public WebElement getCityField(){
        return driver.findElement(By.id("cityVillage"));
    }

    public WebElement getStateField(){
        return driver.findElement(By.id("stateProvince"));
    }

    public WebElement getCountryField(){
        return driver.findElement(By.id("country"));
    }

    public WebElement getPostalCodeField(){
        return driver.findElement(By.id("postalCode"));
    }

    public WebElement getPhoneNumberField(){
        return driver.findElement(By.cssSelector("input[name='phoneNumber']"));
    }

    public WebElement getRelationDropDown(){
        return driver.findElement(By.id("relationship_type"));
    }

    public WebElement getPersonNameField(){
        return driver.findElement(By.className("person-typeahead"));
    }

    public WebElement getSubmitField(){
        return driver.findElement(By.id("submit"));
    }

    public void registerPatient(String firstName, String middleName, String familyName, String gender, String years, String months, String address, String address2, String city, String state, String country, String pincode, String phoneNumber, String relation, String person){
        getFirstName().sendKeys(firstName);
        getMiddlename().sendKeys(middleName);
        getFamilyName().sendKeys(familyName);
        getNext().click();
        Select selectObject = new Select(getPatientGender());
        selectObject.selectByValue(gender);
        getNext().click();

        getEstimatedYearsField().sendKeys(years);
        getEstimatedMonthsField().sendKeys(months);
        getNext().click();

        getAddress1Field().sendKeys(address);
        getAddress2Field().sendKeys(address2);
        getCityField().sendKeys(city);
        getStateField().sendKeys(state);
        getCountryField().sendKeys(country);
        getPostalCodeField().sendKeys(pincode);
        getNext().click();

        getPhoneNumberField().sendKeys(phoneNumber);
        getNext().click();

        Select relationshipDropDown = new Select(getRelationDropDown());
        relationshipDropDown.selectByVisibleText(relation);
        getPersonNameField().sendKeys(person);
        getNext().click();

        getSubmitField().click();
    }
}
