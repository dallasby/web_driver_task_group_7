package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.TestBase;

public class LaptopSearchPage extends TestBase {

	public LaptopPage laptopSearchfound() {
		WebElement actualElement = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
		return new LaptopPage();
	}
}