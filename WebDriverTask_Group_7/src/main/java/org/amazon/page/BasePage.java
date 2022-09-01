package org.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    public void openAmazon() {
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();
    }

    public MainPage goToTheHomePage() {
        webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@id='nav-logo-sprites']"))).click();
        waitForPageToBeFullyLoaded();
        return new MainPage(webDriver);
    }

    public void waitForPageToBeFullyLoaded() {
        webDriverWait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                        .equals("complete"));
    }

    public void close() {
        webDriver.close();
        webDriver.quit();
    }
}
