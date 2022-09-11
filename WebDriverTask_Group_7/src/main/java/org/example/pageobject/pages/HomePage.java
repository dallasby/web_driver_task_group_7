package org.example.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement category;

    public CategoryPage openCategory() {
        this.category = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//img[@alt=\"Headsets\"]")));
        this.category.click();
        return new CategoryPage(webDriver);
    }

    public HomePage open() {
        webDriver.get("https://amazon.com");
        return this;
    }

}
