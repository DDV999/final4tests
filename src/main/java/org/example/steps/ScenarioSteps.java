package org.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioSteps {
    ChoosingPolicySteps choosingPolicySteps = new ChoosingPolicySteps();
    FormalizationSteps formalizationSteps = new FormalizationSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    PageTravelInsuranceSteps pageTravelInsuranceSteps = new PageTravelInsuranceSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainPageSteps.stepClickButtonMainMenu(menuItem);
    }

    @When("^выбран пункт подменю \"(.+)\"$")
    public void stepSelectSubMenu(String menuItem) {
        mainPageSteps.stepClickButtonSubMenu(menuItem);
    }

    @When("^выполнено нажатие на кнопку \"Страхование путешественников\"$")
    public void stepSelectInsuranceTravels() {
        insuranceSteps.stepClickButtonInsurance();
    }

    @When("^выполнено нажатие на кнопку \"Оформить онлайн\"$")
    public void stepClickButtonOnlineRegistration() {
        pageTravelInsuranceSteps.stepClickButtonOnline();
    }

    @When("^выполнено нажатие на кнопку \"Оформить на сайте\"$")
    public void stepClickButtonSiteRegistration() {
        pageTravelInsuranceSteps.stepClickButtonSite();
    }

    @When("^выполнено нажатие на кнопку \"Минимальная\"$")
    public void stepClickButtonMinimal() throws InterruptedException {
        choosingPolicySteps.stepClickButtonMin();
    }

    @When("^выполнено нажатие на кнопку \"Оформить\"$")
    public void stepClickButtonCheckout() {
        choosingPolicySteps.stepClickButtonCheckout();
    }

    @When("^заполняются поля:$")
    public void stepSetFillFields(DataTable fields) {
        fields.<String, String>asMap(String.class, String.class)
                .forEach((field, value) -> formalizationSteps.fillField(field, value));
    }

    @When("^выполнено нажатие на кнопку пол - \"Мужской\"$")
    public void stepSelectMan() {
        formalizationSteps.stepSelectSexM();
    }

    @Then("^выполнено нажатие на кнопку \"Продолжить\"$")
    public void stepClickButtonContinue() {
        formalizationSteps.stepClickButtonNext();
    }

    @When("^нажимаем кнопку \"Закрыть\"$")
    public void stepClickButtonClose() {
        insuranceSteps.stepClickButtonClose();
    }
}
