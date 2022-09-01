package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.TestBase;

public class NoProductPage extends TestBase {
	
	public void NoProductFound() {
		
		WebElement actualText = driver.findElement(By.xpath("//span[normalize-space()='No results for']"));
		String actualTextStr = actualText.getText();
		String expectedText = "No results for";
		Assert.assertEquals(actualTextStr, expectedText);
		
	}

}
