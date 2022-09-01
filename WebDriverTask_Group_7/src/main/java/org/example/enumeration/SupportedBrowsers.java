package org.example.enumeration;

import org.example.invoker.implementations.WebDriverInvoker;
import org.example.invoker.implementations.LocalChromeInvoker;
import org.example.invoker.implementations.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {

    LOCAL_CHROME(new LocalChromeInvoker()),

    LOCAL_FIREFOX(new LocalFirefoxInvoker()),;


    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver(){
        return webDriverInvoker.invokeWebDriver();
    }
}
