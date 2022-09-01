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

    private WebElement AddedToCartConfirmationText = new WebDriverWait(webDriver, Duration.ofSeconds(10))
            .until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Added to Cart')]")));;

    private WebElement CartItemsCount = new WebDriverWait(webDriver, Duration.ofSeconds(10))
            .until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//span[@id=\"nav-cart-count\" and text()=\"1\"]")));

    public String checkIfAddedToCartText(){
        return AddedToCartConfirmationText.getText();
    }

    public String checkIfAddedToCartCount(){
        return CartItemsCount.getText();
    }

    public CartPage openCart() {
        this.CartItemsCount = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[@id=\"nav-cart-count\" and text()=\"1\"]")));
        this.CartItemsCount.click();
        return new CartPage(webDriver);
    }
}

