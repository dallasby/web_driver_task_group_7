package org.example.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage extends BasePage {

    protected CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement Item;

    public ProductPage openProduct() {
        this.Item = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//img[starts-with(@alt, \"Sponsored Ad - AIHOOR Gaming Headset with Virtual\")]")));
        this.Item.click();
        return new ProductPage(webDriver);
    }
}
