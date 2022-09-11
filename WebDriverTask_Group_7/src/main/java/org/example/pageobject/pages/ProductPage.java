package org.example.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    protected ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement addToCartButton;

    public AddToCartConfirmationPage addProductToCart() {
        this.addToCartButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//input[@id=\"add-to-cart-button\"]")));
        this.addToCartButton.click();
        return new AddToCartConfirmationPage(webDriver);
    }
}
