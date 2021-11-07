package org.example.pages;

import org.example.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoosingPolicyPage extends BasePageObject{
    @FindBy(xpath = "//h3[contains(text(),'Минимальная')]")
    public WebElement buttonMin;

    @FindBy(xpath = "//*[contains(text(),'Оформить')]")
    public WebElement buttonCheckout;

    public ChoosingPolicyPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
