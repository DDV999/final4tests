package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.FormalizationPage;

import java.util.HashMap;

public class FormalizationSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        new FormalizationPage().fillField(field, value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields) {
        fields.forEach(this::fillField);
    }

    @Step("Нажать на кнопку Продолжить")
    public void stepClickButtonNext() {
        new FormalizationPage().next.click();
    }

    @Step("Выбрать пол Мужской")
    public void stepSelectSexM() {
        new FormalizationPage().sexM.click();
    }

    @Step("Проверка значений в полях")
    public void assertscheck() {
        new FormalizationPage().checkAsserts();
    }
}
