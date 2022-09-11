package org.example.american_address.modules;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ApplyButton {
    private static final By APPLY_BUTTON = By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input");

    public ContinueButton applyButtonClick() {
        $(APPLY_BUTTON).click();
        return new ContinueButton();
    }
}
