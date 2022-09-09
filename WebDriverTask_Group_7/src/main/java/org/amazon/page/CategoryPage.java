package org.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CategoryPage extends BasePage {

    private final String name;

    public CategoryPage(WebDriver webDriver, String categoryName) {
        super(webDriver);
        name = categoryName;
    }

    public CategoryPage filterByBrand(String brandName) {
        webDriver.findElement(By.linkText("See more")).click();
        webDriver.findElement(By.xpath(String.format("//li[contains(@id, '%s')]//a", brandName))).click();
        return this;
    }

    public CategoryPage filterByPrice(String priceRange) {
        webDriver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", priceRange))).click();
        return this;
    }

    public CategoryPage sortBy(String ordering) throws InterruptedException {
        WebElement dropDownButton = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[@class='a-dropdown-prompt']")));
        dropDownButton.click();
        WebElement lowToHighPriceDropdownLink = webDriverWait.until(visibilityOfElementLocated(By.linkText(ordering)));
        lowToHighPriceDropdownLink.click();
        Thread.sleep(1000);
        waitForPageToBeFullyLoaded();
        return this;
    }

    public List<String> getItemNames() {
        return webDriverWait.until(visibilityOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 's-main-slot s-result-list')]//h2//a//span[@class='a-size-medium a-color-base a-text-normal']")))
                .stream().map(WebElement::getText).collect(toList());
    }

    public List<Double> getItemPrices() {
        return webDriverWait.until(visibilityOfElementLocated(
                By.xpath("//span[@data-component-type='s-search-results']")))
                .findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']/span[@class='a-offscreen']"))
                .stream().map(priceElement -> priceElement.getAttribute("textContent")).map(price -> price.substring(1))
                .mapToDouble(Double::valueOf).boxed().collect(toList());
    }
}
