package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeliverToTest {

    @Test
    public void deliverToFunctionality() {
        addingSystemProperty();

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.amazon.com/");

        webDriver.manage().window().maximize();

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

//        Assert.assertTrue(clickOnContinueButton.isDisplayed());

//        WebElement clickOnChangeAddressButton = webDriver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[2]/span"));
//
//        if (clickOnChangeAddressButton.isDisplayed()) {
//            clickOnChangeAddressButton.click();
//        }


//        WebElement shouldBeJuneauAddress = new WebDriverWait(webDriver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"Juneau 99801\")]")));
//
//        Assert.assertEquals("Juneau 99801", shouldBeJuneauAddress.getText());

        webDriver.quit();
        webDriver.close();
    }

    @Test
    public void verifyIfPolandIsPresent() {
        addingSystemProperty();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();

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
        addingSystemProperty();

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
        clickOnSpain.click();

        WebElement clickOnDoneButton =webDriver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div[2]/span/span"));
        clickOnDoneButton.click();

        WebElement clickOnAnyElement = webDriver.findElement(By.xpath("//*[@id=\"-3HXN1GB_8cWPmgkzjtQ7w\"]/div[2]/a/div/img"));
//        WebElement clickOnAnyElement = new WebDriverWait(webDriver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"-3HXN1GB_8cWPmgkzjtQ7w\"]/div[2]/a/div/img")));
        clickOnAnyElement.click();
    }

    public void addingSystemProperty() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\pavel\\Desktop\\web_driver_task_group_7\\web_driver_task_group_7\\WebDriverTask_Group_7\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );
    }
}
