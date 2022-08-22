package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeliverToTest {
    private WebDriver startingWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();
        return webDriver;
    }

    @AfterTest
    public void shutDownWebDriver() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void verifyIfAmericanAddressIsPresent() {
        WebDriver webDriver = startingWebDriver();

        WebElement clickOnLogoDeliverTo = webDriver.findElement(By.id("nav-global-location-popover-link"));
        clickOnLogoDeliverTo.click();

        WebElement enteringUsZipCode = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipUpdateInput")));
        enteringUsZipCode.sendKeys("99801");

        WebElement clickOnApplyButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipUpdate")));
        clickOnApplyButton.click();

        WebElement clickOnContinueButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-popover-1\"]/div/div[2]/span/span")));
        clickOnContinueButton.click();
        webDriver.navigate().refresh();

        WebElement checkAddress = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("glow-ingress-line2")));
        Assert.assertEquals(checkAddress.getText(), "Juneau 99801" + "\u200C");
    }

    @Test
    public void verifyIfPolandIsPresentInDropDown() {
        WebDriver webDriver = startingWebDriver();

        WebElement clickOnLogoDeliverTo = webDriver.findElement(By.id("nav-global-location-popover-link"));
        clickOnLogoDeliverTo.click();

        WebElement clickOnCountriesDropdown = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXCountryListDropdown")));
        clickOnCountriesDropdown.click();

        WebElement checkPoland = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXCountryList_178")));
        Assert.assertEquals(checkPoland.getText(), "Poland");
    }

    @Test
    public void verifyShippingAddressToSelectedCountry() {
        WebDriver webDriver = startingWebDriver();

        WebElement clickOnLogoDeliverTo = webDriver.findElement(By.id("nav-global-location-popover-link"));
        clickOnLogoDeliverTo.click();

        WebElement clickOnCountriesDropdown = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXCountryListDropdown")));
        clickOnCountriesDropdown.click();

        WebElement clickOnSpain = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXCountryList_209")));
        Assert.assertEquals(clickOnSpain.getText(), "Spain");
        clickOnSpain.click();

        WebElement clickOnDoneButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-popover-1\"]/div/div[2]/span/span/span/button")));
        clickOnDoneButton.click();
        webDriver.navigate().refresh();

        WebElement clickOnAnyElement = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,\"Keyboards\")]")));
        clickOnAnyElement.click();

        WebElement clickOnFirstElementOnWebPage = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//img[contains(@alt,'Sponsored Ad - Fiodio Mechanical Gaming Keyboard, LED Rainbow Gaming Backlit, 104 Anti-ghosting Keys, Quick-Response Black...')][1]")));
        clickOnFirstElementOnWebPage.click();

        WebElement verifyThatValueIsSpain = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"amazonGlobal_feature_div\"]/span[1]")));
        Assert.assertEquals(verifyThatValueIsSpain.getText(), "No Import Fees Deposit & $13.74 Shipping to Spain");
    }
}
