package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchFunctionalityTest {
    WebDriver driver;
    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver",
                "D:\\Rupali\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test(priority = 2)
    public void laptopSearchTest() {
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test(priority = 3)
    public void productFoundTest() {

        // located element with contains()
        List<WebElement> WebElements = driver.findElements(By.xpath("//*[contains(text(),'Laptop')]"));
        int size = WebElements.size();
        System.out.println(size);
        for (int i = 1; i < size; i++) {
            String s = WebElements.get(i).getText();
            System.out.println("Text is " + s);
        }

        driver.findElement(By.xpath(
                        "//*[@id=\'search\']/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
                .click();
        System.out.println(driver.getTitle());

    }
    @AfterClass
    public  void quit(){
        driver.close();
    }
}
