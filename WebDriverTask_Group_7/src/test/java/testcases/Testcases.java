package testcases;

import org.testng.annotations.Test;

import pages.HomePage;

public class Testcases {

	
	private final HomePage SP = new HomePage();
	@Test
	public void aNoProductFound()
	{

		SP.noSearchProduct().NoProductFound();
	}
	@Test
	public void bSearchLaptopFound()
	{
		SP.laptopSearch().laptopSearchfound();
	}
	@Test
	public void cFoundLaptopPage()
	{
		SP.laptopSearch().laptopSearchfound().laptopFound();
	}
	
	
	

}
