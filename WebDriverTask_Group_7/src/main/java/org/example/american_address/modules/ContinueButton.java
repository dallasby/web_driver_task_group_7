package org.example.american_address.modules;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContinueButton {
    private static final By CLICK_ON_CONTINUE_BUTTON = By.xpath("//*[@id=\"a-popover-1\"]/div/div[2]/span/span");

    public PageWithAmericanAddress clickContinue() {
        $(CLICK_ON_CONTINUE_BUTTON).click();
        Selenide.refresh();
        return new PageWithAmericanAddress();
    }
}
