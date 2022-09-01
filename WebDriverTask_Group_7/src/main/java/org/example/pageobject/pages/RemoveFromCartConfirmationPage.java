package org.example.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RemoveFromCartConfirmationPage extends BasePage {

    protected RemoveFromCartConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    private WebElement RemovalConfirmationText = new WebDriverWait(webDriver, Duration.ofSeconds(10))
            .until(ExpectedConditions
                           .visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Your Amazon Cart is empty.')]")));

    private WebElement RemovalFinalPrice = new WebDriverWait(webDriver, Duration.ofSeconds(10))
            .until(ExpectedConditions
                           .visibilityOfElementLocated(By.xpath("//span[contains(text(), \"$0.00\")]")));

    public String checkIfRemovedFromCartPrice() {
        return RemovalFinalPrice.getText();
    }

    public String checkIfRemovedFromCartText() {
        return RemovalConfirmationText.getText();
    }
}

