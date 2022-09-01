package org.example.factory;

import org.example.enumeration.SupportedBrowsers;
import org.example.pageobject.properties.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public WebDriver getWebDriver() {

        return SupportedBrowsers.valueOf(new PropertyHolder().readProperty("browser")).getWebDriver();
    }
}
