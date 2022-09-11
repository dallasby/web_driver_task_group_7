package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.TestBase;

public class HomePage extends TestBase {

	public NoProductPage noSearchProduct() {
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBar.click();
		searchBar.sendKeys("@##!#@##35446464646");
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();
		return new NoProductPage();
	}

	public LaptopSearchPage laptopSearch() {

		driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).click();
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBar.click();
		searchBar.sendKeys("Laptop");
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();
		return new LaptopSearchPage();

	}

}
