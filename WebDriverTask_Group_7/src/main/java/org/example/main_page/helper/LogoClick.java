package org.example.main_page.helper;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogoClick {
    private static final By LOGO_DELIVER_TO = By.id("nav-global-location-popover-link");

    public static void clickOnLogoDeliverTo() {
        $(LOGO_DELIVER_TO).click();
    }
}
