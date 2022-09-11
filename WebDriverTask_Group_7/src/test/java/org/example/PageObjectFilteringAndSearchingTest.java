package org.example;

import com.google.common.collect.Ordering;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.amazon.page.BasePage;
import org.amazon.page.CategoryPage;
import org.amazon.page.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjectFilteringAndSearchingTest {

    BasePage currentPage;

    @BeforeClass
    public void startWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        currentPage = new MainPage(webDriver);
        currentPage.openAmazon();
    }

    @Test
    public void filterByBrand_shouldDisplayItemsWithSelectedBrandOnly() {
        MainPage mainPage = currentPage.goToTheHomePage();
        CategoryPage headsetsPage = mainPage.clickTile("Headsets");
        List<String> itemNames = headsetsPage.filterByBrand("Razer").getItemNames();
        assertEquals(itemNames.size(), itemNames.stream().map(String::toLowerCase).filter(item -> item.contains("razer")).count(),
                "Filter by brand returns unexpected items:\n"
                        + itemNames.stream().filter(item -> !item.contains("Razer")).collect(joining("\n")));
    }

    @Test
    public void filterByPrice_shouldDisplayItemsWithSelectedPriceRangeOnly() {
        MainPage mainPage = currentPage.goToTheHomePage();
        CategoryPage keyboardsPage = mainPage.clickTile("Keyboards");
        List<Double> itemPrices = keyboardsPage.filterByPrice("$10 to $15").getItemPrices();
        assertTrue(itemPrices.stream().allMatch(price -> price >= 10. && price <= 15.),
                "Filter by price returns items with price out of boundary.");
    }

    @Test
    public void sortByPrice_shouldDisplayItemsInSelectedOrder() throws Exception {
        MainPage mainPage = currentPage.goToTheHomePage();
        CategoryPage chairsPage = mainPage.clickTile("Chairs");
        List<Double> itemPrices = chairsPage.sortBy("Price: Low to High").getItemPrices();
        assertTrue(Ordering.natural().isOrdered(itemPrices.subList(0, itemPrices.size() - 4)),//ignore sponsored items
                "Sorting by low to high price returns wrong sorting order.");
    }

    @AfterClass
    public void closeWebDriver() {
        currentPage.close();
    }
}
