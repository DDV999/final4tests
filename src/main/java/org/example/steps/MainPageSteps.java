package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.MainPage;

public class MainPageSteps {
    @Step("Нажать на кнопку Меню {0}")
    public void stepClickButtonMainMenu(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Нажать на кнопку подменю {0}")
    public void stepClickButtonSubMenu(String menuItem) {
        new MainPage().selectSubMenu(menuItem);
    }
}
