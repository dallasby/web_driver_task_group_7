package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.HomePage;

public class Testcases {

	private final HomePage SP = new HomePage();
	@Test
	public void aNoProductFound()
	{
		String actualTextStr = SP.noSearchProduct().NoProductFound();
		String expectedText = "No results for";
		Assert.assertEquals(actualTextStr, expectedText);
	}

	@Test
	public void bSearchLaptopFound()
	{
		SP.laptopSearch().laptopSearchfound();
		Assert.assertTrue(true,"Laptop Search Found");
	}

	@Test
	public void cFoundLaptopPage()
	{
		String actualTitle = SP.laptopSearch().laptopSearchfound().laptopFound();
		String expectedtitle = "Amazon.com: 2022 New HP 15 Laptop, 15.6\" HD LED Display, Intel Dual-Core Processor, Intel UHD Graphics, 16GB DDR4 RAM, 1TB SSD, Ethernet Port, USB Type-C, Long Battery Life, Windows 11 : Electronics";
		Assert.assertEquals(actualTitle, expectedtitle);
	}

	@AfterSuite
	public void baseTest()
	{
		TestBase.tearDown();
	}

}
