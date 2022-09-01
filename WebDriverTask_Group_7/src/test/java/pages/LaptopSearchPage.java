package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.TestBase;

public class LaptopSearchPage extends TestBase {

	public LaptopPage laptopSearchfound() {
		WebElement actualElement = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
		String actualElementStr = actualElement.getText();
		String actualElementStrUpdated = actualElementStr.replaceAll("[^a-zA-Z]", "");
		String expectedElement = "Laptop";
		Assert.assertEquals(actualElementStrUpdated, expectedElement);
		
		return new LaptopPage();

	}

	
	

}
