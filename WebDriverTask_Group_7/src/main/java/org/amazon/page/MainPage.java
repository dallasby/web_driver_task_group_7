package org.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CategoryPage clickTile(String categoryName) {
        webDriverWait.until(visibilityOfElementLocated
                (By.xpath(String.format("//a[@aria-label='%s']", categoryName)))).click();
        waitForPageToBeFullyLoaded();
        return new CategoryPage(webDriver, categoryName);
    }
}
