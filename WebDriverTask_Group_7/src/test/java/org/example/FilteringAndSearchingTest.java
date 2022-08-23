package org.example;

import com.google.common.collect.Ordering;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class FilteringAndSearchingTest {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeClass
    public void startWebDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    @Test
    public void FeaturedBrand() throws Exception {
        goHome();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[@aria-label='Headsets']"))).click();
        WebElement brandsRefinements = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("brandsRefinements")));
        brandsRefinements.findElement(By.xpath("//li[contains(@id, 'Razer')]//a")).click();
        List<WebElement> items = webDriverWait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[contains(@class, 's-main-slot s-result-list')]//h2//a//span[starts-with(text(), 'Razer')][@class='a-size-medium a-color-base a-text-normal']")));
        assertEquals(items.size(), items.stream().map(WebElement::getText).filter(item -> item.contains("Razer")).count(), "Filter by brand returns unexpected items.");
    }

    @Test
    public void FeaturedPrice() {
        goHome();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[@aria-label='Keyboards']"))).click();
        WebElement priceRefinements = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.id("priceRefinements")));
        priceRefinements.findElement(By.xpath("//span[contains(text(),'$10 to $15')]")).click();
        WebElement searchResults = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[@data-component-type='s-search-results']")));
        List<WebElement> webElements = searchResults.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']/span[@class='a-offscreen']"));
        assertTrue(webElements.stream().map(priceElement -> priceElement.getAttribute("textContent")).map(price -> price.substring(1)).mapToDouble(Double::valueOf).allMatch(price -> price >= 10. && price <= 15.),
                "Filter by price returns items with price out of boundary.");
    }

    @Test
    public void SortingPrice() throws InterruptedException {
        goHome();
        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//a[@aria-label='Chairs']"))).click();
        WebElement dropDownButton = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[@class='a-dropdown-prompt']")));
        dropDownButton.click();
        WebElement lowToHighPriceDropdownLink = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.linkText("Price: Low to High")));
        lowToHighPriceDropdownLink.click();
        WebElement searchResults = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//span[@data-component-type='s-search-results']")));
        Thread.sleep(1000);
        List<WebElement> webElements = searchResults.findElements(By.xpath("//div[@data-component-type='s-search-result']//div[contains(@class, 's-card-container')]//span[@class='a-price']/span[@class='a-offscreen']"));
        List<Double> prices = webElements.stream().map(priceElement -> priceElement.getAttribute("textContent")).map(price -> price.substring(1)).mapToDouble(Double::valueOf).boxed().collect(Collectors.toList());
        assertFalse(prices.isEmpty());
        assertTrue(Ordering.natural().isOrdered(prices.subList(0, prices.size() - 4)), "Sorting by low to high price returns wrong sorting order.");//ignore sponsored items
    }

    @AfterClass
    public void closeWebDriver() {
        webDriver.close();
        webDriver.quit();
    }

    private void goHome() {
        webDriver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).click();
    }
}