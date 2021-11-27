package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.TravelInsurancePage;

public class PageTravelInsuranceSteps {
    @Step("Нажать на кнопку Оформить онлайн")
    public void stepClickButtonOnline() {
        new TravelInsurancePage().buttonCheckoutOnline.click();
    }

    @Step("Нажать на кнопку Оформить на сайте")
    public void stepClickButtonSite() {
        new TravelInsurancePage().buttonCheckoutOnSite.click();
    }
}
