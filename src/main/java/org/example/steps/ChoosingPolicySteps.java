package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.ChoosingPolicyPage;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.example.steps.BaseSteps.driver;

public class ChoosingPolicySteps {

    @Step("Нажать на кнопку Минимальная {0}")
    public void stepClickButtonMin() throws InterruptedException {
        sleep(5000);
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
                driver.switchTo().window(String.valueOf(tabs2.get(1)));
        new ChoosingPolicyPage().buttonMin.click();
    }

    @Step("Нажать на кнопку Оформить {0}")
    public void stepClickButtonCheckout() {
        new ChoosingPolicyPage().buttonCheckout.click();
    }
}
