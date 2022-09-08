package org.example.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartConfirmationPage extends BasePage {

    protected AddToCartConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement addedToCartConfirmationText = new WebDriverWait(webDriver, Duration.ofSeconds(10))
            .until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Added to Cart')]")));;

    private WebElement cartItemsCount = new WebDriverWait(webDriver, Duration.ofSeconds(10))
            .until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//span[@id=\"nav-cart-count\" and text()=\"1\"]")));

    public String checkIfAddedToCartText(){
        return this.addedToCartConfirmationText.getText();
    }

    public String checkIfAddedToCartCount(){
        return this.cartItemsCount.getText();
    }

    public CartPage openCart() {
        this.cartItemsCount.click();
        return new CartPage(webDriver);
    }
}

