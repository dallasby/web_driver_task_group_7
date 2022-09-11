package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.TestBase;

public class NoProductPage extends TestBase {

	public String NoProductFound() {
		WebElement actualText = driver.findElement(By.xpath("//span[normalize-space()='No results for']"));
		String actualTextStr = actualText.getText();

		return actualTextStr;
	}

}
