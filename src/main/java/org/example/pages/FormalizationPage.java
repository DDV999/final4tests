package org.example.pages;

import org.example.steps.BaseSteps;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormalizationPage extends BasePageObject {

    @FindBy(xpath = "//h2[text()='Страхование путешественников']")
    public WebElement title;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surNameVsr;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameVsr;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDateVsr;

    @FindBy(id = "person_lastName")
    WebElement personLastName;

    @FindBy(id = "person_firstName")
    WebElement personFirstName;

    @FindBy(id = "person_middleName")
    WebElement personMiddleName;

    @FindBy(id = "person_birthDate")
    WebElement personBirthDate;

    @FindBy(xpath = "//label[contains(text(),'Мужской')]")
    public WebElement sexM;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    public WebElement next;

    public FormalizationPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        (new WebDriverWait(BaseSteps.getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(title));
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия_":
                fillField(surNameVsr, value);
                break;
            case "Имя_":
                fillField(nameVsr, value);
                break;
            case "Дата рождения_":
                fillField(birthDateVsr, value);
                break;
            case "Имя":
                fillField(personFirstName, value);
                break;
            case "Фамилия":
                fillField(personLastName, value);
                break;
            case "Отчество":
                fillField(personMiddleName, value);
                break;
            case "Дата рождения":
                fillField(personBirthDate, value);
                personBirthDate.sendKeys(Keys.TAB);
                break;
            case "Серия":
                fillField(passportSeries, value);
                break;
            case "Номер":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDate, "");
                fillField(documentDate, value);
                break;
            case "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }
}
