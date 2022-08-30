package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SearchFunctionalityTest {
    WebDriver driver;
    @BeforeClass
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        }
    @Test(priority = 1)
    public  void noProductTest(){
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.click();
        searchBar.sendKeys("@##!#@##35446464646");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();
        WebElement actualText = driver.findElement(By.xpath("//span[normalize-space()='No results for']"));
        String actualTextStr = actualText.getText();
        String expectedText = "No results for";
        Assert.assertEquals(actualTextStr, expectedText);
            }
    @Test(priority = 2)
    public void laptopSearchTest() {
        driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).click();
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.click();
        searchBar.sendKeys("Laptop");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();
        WebElement actualElement = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualElementStr = actualElement.getText();
        String actualElementStrUpdated = actualElementStr.replaceAll("[^a-zA-Z]", "");
        String expectedElement = "Laptop";
        Assert.assertEquals(actualElementStrUpdated, expectedElement);

    }
    @Test(priority = 3)
    public void productFoundTest() {

        // located element with contains()
        List<WebElement> WebElements = driver.findElements(By.xpath("//*[contains(text(),'Laptop')]"));
        int size = WebElements.size();
         for (int i = 1; i < size; i++) {
            String s = WebElements.get(i).getText();
                    }

        driver.findElement(By.xpath(
                        "//span[normalize-space()='HP 15t-dy200 CTO 15.6\" FHD IPS Touchscreen Laptop, Intel i7-1165G7 (up to 4.7 GHz), 16GB (2 x 8GB) DDR4, 512GB SSD, Win 10, Natural Silver']"))
                .click();
        String actualtitle = driver.getTitle();

        String expectedtitle = "Amazon.com: HP 15t-dy200 CTO 15.6\" FHD IPS Touchscreen Laptop, Intel i7-1165G7 (up to 4.7 GHz), 16GB (2 x 8GB) DDR4, 512GB SSD, Win 10, Natural Silver : Electronics";
        Assert.assertEquals(actualtitle, expectedtitle);

    }
    @AfterClass
    public  void quit(){
        driver.close();
    }
}
