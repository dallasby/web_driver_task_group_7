package org.example;

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

public class DeliverToTest {
    @Test
    public void verifyIfAmericanAddressIsPresent() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();

        webDriver.navigate().refresh();

        WebElement clickOnLogoDeliverTo = webDriver.findElement(By.id("nav-global-location-popover-link"));
        clickOnLogoDeliverTo.click();

        Assert.assertTrue(clickOnLogoDeliverTo.isDisplayed());

        WebElement enteringUsZipCode = webDriver.findElement(By.id("GLUXZipUpdateInput"));
        enteringUsZipCode.sendKeys("99801");

        WebElement clickOnApplyButton = webDriver.findElement(By.id("GLUXZipUpdate"));
        clickOnApplyButton.click();

        Assert.assertTrue(clickOnApplyButton.isDisplayed());

        WebElement clickOnContinueButton = webDriver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div[2]/span/span"));
        clickOnContinueButton.click();

        webDriver.navigate().refresh();

        WebElement checkAddress = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("glow-ingress-line2")));

        Assert.assertEquals(checkAddress.getText(), "Juneau 99801" + "\u200C");

        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void verifyIfPolandIsPresent() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();

        webDriver.navigate().refresh();

        WebElement clickOnLogoDeliverTo = webDriver.findElement(By.id("nav-global-location-popover-link"));
        clickOnLogoDeliverTo.click();

        Assert.assertTrue(clickOnLogoDeliverTo.isDisplayed());

        WebElement clickOnCountriesDropdown = webDriver.findElement(By.id("GLUXCountryListDropdown"));
        clickOnCountriesDropdown.click();

        WebElement checkPoland = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXCountryList_178")));

        Assert.assertEquals(checkPoland.getText(), "Poland");

        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void verifyShippingAddressToSelectedCountry() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();

        WebElement clickOnLogoDeliverTo = webDriver.findElement(By.id("nav-global-location-popover-link"));
        clickOnLogoDeliverTo.click();

        Assert.assertTrue(clickOnLogoDeliverTo.isDisplayed());

        WebElement clickOnCountriesDropdown = webDriver.findElement(By.id("GLUXCountryListDropdown"));
        clickOnCountriesDropdown.click();

        WebElement clickOnSpain = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXCountryList_209")));

        Assert.assertEquals(clickOnSpain.getText(), "Spain");

        clickOnSpain.click();

        WebElement clickOnDoneButton = webDriver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div[2]/span/span/span/button"));
        clickOnDoneButton.click();

        webDriver.navigate().refresh();

        WebElement clickOnAnyElement = webDriver.findElement(By.xpath("\"//*[@id=\\\"BYdQro8WUd1fZv2motiZCQ\\\"]/div[2]/div[1]/div[2]\""));
//        WebElement clickOnAnyElement = new WebDriverWait(webDriver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BYdQro8WUd1fZv2motiZCQ\"]/div[2]/div[1]/div[2]")));
        clickOnAnyElement.click();

//        webDriver.close();
//        webDriver.quit();
    }

    @BeforeTest
    public void addingSystemProperty() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\pavel\\Desktop\\web_driver_task_group_7\\web_driver_task_group_7\\WebDriverTask_Group_7\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );
    }
}
