package com.undostres.qa.pages;

import com.undostres.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PatientsPage extends TestBase {

    public WebElement getPatientSearch() {
        return patientSearch;
    }

    @FindBy(id = "patient-search")
    WebElement patientSearch;

    public PatientsPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getResultsTable(){
        return driver.findElement(By.id("patient-search-results-table"));
    }

    public  void patientSearch(String patientId){
        WebElement searchField = getPatientSearch();
        searchField.sendKeys(patientId);
    }
    public PatientDetailsPage getPatientDetailsPage(WebElement element) {
        element.click();
        return new PatientDetailsPage();
    }

}
