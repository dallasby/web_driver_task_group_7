package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class FilteringAndSearchingTest {

    @Test
    public void FeaturedBrand() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\andrz\\IdeaProjects\\web_driver_task_group_7\\WebDriverTask_Group_7\\src\\test\\resources\\webdriver\\chromedriver"
        );

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://amazon.com");
        webDriver.manage().window().maximize();
        WebElement logo = webDriver.findElement(By.xpath("//a[@id=\"nav-logo-sprites\"]"));
        Assert.assertTrue(logo.isDisplayed());
        webDriver.close();
        webDriver.quit();
    }

//    @Test
//    public void FeaturedPrice() {
//        System.setProperty(
//                "webdriver.chrome.driver",
//                "C:\\Users\\andrz\\IdeaProjects\\web_driver_task_group_7\\src\\test\\resources\\webdriver\\chromedriver"
//        );
//
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("https://amazon.com");
//        webDriver.manage().window().maximize();
//
//
//        webDriver.close();
//        webDriver.quit();
//    }
//
//    @Test
//    public void SortingPrice() {
//        System.setProperty(
//                "webdriver.chrome.driver",
//                "C:\\Users\\andrz\\IdeaProjects\\web_driver_task_group_7\\src\\test\\resources\\webdriver\\chromedriver"
//        );
//
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("https://amazon.com");
//        webDriver.manage().window().maximize();
//
//
//        webDriver.close();
//        webDriver.quit();
//    }
}