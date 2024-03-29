package org.example.util;

import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestStepFinished;
import io.qameta.allure.Allure;
import io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm;
import org.example.steps.BaseSteps;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureReporter extends AllureCucumber4Jvm {
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
        super.setEventPublisher(publisher);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        if (!event.result.isOk(false)) {
            Allure.getLifecycle().addAttachment("Скриншот в момент ошибки", "image/png", "png", new ByteArrayInputStream(((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }
}
