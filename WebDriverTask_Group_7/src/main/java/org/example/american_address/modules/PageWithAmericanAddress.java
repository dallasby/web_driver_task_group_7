package org.example.american_address.modules;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageWithAmericanAddress {
    private static final By CHECK_ADDRESS = By.id("glow-ingress-line2");

    public String checkAmericanAddress() {
        return $(CHECK_ADDRESS).getText();
    }
}
