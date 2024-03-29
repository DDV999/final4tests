package org.example.pages;

import org.example.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

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

    public void checkAsserts() {
        assertEquals("Иванова", BaseSteps.getDriver().findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Ольга", BaseSteps.getDriver().findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("09.07.2021", BaseSteps.getDriver().findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        assertEquals("Сергеев", BaseSteps.getDriver().findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Иван", BaseSteps.getDriver().findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Иванович", BaseSteps.getDriver().findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("09.07.2003", BaseSteps.getDriver().findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("1234", BaseSteps.getDriver().findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("123456", BaseSteps.getDriver().findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("09.07.2019", BaseSteps.getDriver().findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("No name", BaseSteps.getDriver().findElement(By.id("documentIssue")).getAttribute("value"));


        BaseSteps.getDriver().findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();
        assertEquals("При заполнении данных произошла ошибка", BaseSteps.getDriver().findElement(By.xpath("//*[@class='alert-form alert-form-error']")).getText());
        assertEquals("Поле не заполнено.", BaseSteps.getDriver().findElement(By.xpath("//legend[text()='Контакты']/..//*[@class='invalid-validate form-control__message']")).getText());
    }
}
