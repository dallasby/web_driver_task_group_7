package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.TestBase;

public class LaptopPage extends TestBase {
	
	public void laptopFound() {
		
		driver.findElement(By.xpath(
				"//span[normalize-space()='2022 New HP 15 Laptop, 15.6\" HD LED Display, Intel Dual-Core Processor, Intel UHD Graphics, 16GB DDR4 RAM, 1TB SSD, Ethernet Port, USB Type-C, Long Battery Life, Windows 11']"))
				.click();
		String actualtitle = driver.getTitle();

		String expectedtitle = "Amazon.com: 2022 New HP 15 Laptop, 15.6\" HD LED Display, Intel Dual-Core Processor, Intel UHD Graphics, 16GB DDR4 RAM, 1TB SSD, Ethernet Port, USB Type-C, Long Battery Life, Windows 11 : Electronics";
		Assert.assertEquals(actualtitle, expectedtitle);

	}

}
