package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.InsurancePage;

public class InsuranceSteps {
    @Step("Нажать на кнопку \"Закрыть\"")
    public void stepClickButtonClose(){
        new InsurancePage().buttonClose.click();
    }

    @Step("Нажать на кнопку Страхование путешественников {0}")
    public void stepClickButtonInsurance() {
        new InsurancePage().buttonTravelInsurance.click();
    }
}
