package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddRemoveItemIntoCart {

    private WebDriver initWebdriver() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriver localWebDriver = new ChromeDriver();
        localWebDriver.get("https://amazon.com");
        localWebDriver.manage().window().maximize();

        return localWebDriver;
    }

    private void initCart(WebDriver cartWebdriver) {

        WebElement openCategory = new WebDriverWait(cartWebdriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt=\"Headsets\"]")));
        openCategory.click();

        WebElement openItem = new WebDriverWait(cartWebdriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[starts-with(@alt, 'Sponsored Ad - Gaming Headset')]")));
        openItem.click();

        WebElement addItemToCart = new WebDriverWait(cartWebdriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"add-to-cart-button\"]")));
        addItemToCart.click();
    }

    @Test
    public void addItemIntoCart() {

        WebDriver webDriver = initWebdriver();

        initCart(webDriver);

        WebElement addToCartConformationText = webDriver.findElement(By.xpath("//span[contains(text(), 'Added to Cart')]"));
        Assert.assertTrue(addToCartConformationText.isDisplayed());

        WebElement addToCartItemQuantity = webDriver.findElement(By.xpath("//span[@id=\"nav-cart-count\" and text()=\"1\"]"));
        Assert.assertTrue(addToCartItemQuantity.isDisplayed());


        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void removeItemFromCart() {

        WebDriver webDriver = initWebdriver();

        initCart(webDriver);

        WebElement addToCartConformationText = webDriver.findElement(By.xpath("//span[contains(text(), 'Added to Cart')]"));
        Assert.assertTrue(addToCartConformationText.isDisplayed());
        Assert.assertEquals(addToCartConformationText.getText(), "Added to Cart");

        WebElement addToCartItemQuantity = webDriver.findElement(By.xpath("//span[@id=\"nav-cart-count\" and text()=\"1\"]"));
        Assert.assertTrue(addToCartItemQuantity.isDisplayed());
        Assert.assertEquals(addToCartItemQuantity.getText(), "1");
        addToCartItemQuantity.click();

        WebElement removeItemFromCart = new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=\"Delete\"]")));
        removeItemFromCart.click();

        WebElement removeFromCartConformationText = new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Your Amazon Cart is empty.')]")));
        Assert.assertTrue(removeFromCartConformationText.isDisplayed());

        WebElement removeFromCartFinalPrice = webDriver.findElement(By.xpath("//span[contains(text(), \"$0.00\")]"));
        Assert.assertTrue(removeFromCartFinalPrice.isDisplayed());


        webDriver.close();
        webDriver.quit();
    }
}
