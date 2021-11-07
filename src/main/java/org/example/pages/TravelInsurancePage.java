package org.example.pages;

import org.example.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelInsurancePage extends BasePageObject {

    @FindBy(xpath = "//*[@class='kitt-button__text'][contains(text(),'Оформить онлайн')]")
    public WebElement buttonCheckoutOnline;
    @FindBy(xpath = "//*[@class='kitt-button__text'][contains(text(),'Оформить на сайте')]")
    public WebElement buttonCheckoutOnSite;

    public TravelInsurancePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
