package org.example.pages;

import org.example.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage extends BasePageObject{
    @FindBy(xpath = "//*[@data-test-id='ProductCatalog_minicard_header'][contains(text(),'Страхование путешественников')]")
    public WebElement buttonTravelInsurance;

    @FindBy(xpath = "//button[contains(text(),'Закрыть') and @class='kitt-cookie-warning__close']")
    public WebElement buttonClose;

    public InsurancePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
