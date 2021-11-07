package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.steps.BaseSteps;

public class MainPage extends BasePageObject{

    @FindBy(xpath = "//*[@class='kitt-top-menu__list kitt-top-menu__list_icons kitt-top-menu__list_center']")
    public WebElement mainMenu;

    @FindBy(xpath = "//*[contains(text(),'Страхование')]/../div[@class='kitt-top-menu__dropdown kitt-top-menu__dropdown_icons']")
    WebElement subMenu;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String itemName) {
        mainMenu.findElement(By.xpath(".//*[contains(text(),'" + itemName + "')]")).click();
    }

    public void selectSubMenu(String itemName) {
        mainMenu.findElement(By.xpath(".//*[contains(text(),'" + itemName + "')]")).click();
    }
}



