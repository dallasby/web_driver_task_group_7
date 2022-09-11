package org.example;

import org.example.main_page.AmazonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliverToFunctionalityWithSelenideTest{
    private final AmazonPage amazonPage = new AmazonPage();

    @Test
    public void verifyIfAmericanAddressIsPresentTest() {
        String shouldBeAmericanAddress = amazonPage
                .openAmazonPage()
                .goingToDeliverLogo()
                .pageForAmerica()
                .settingValueAsAmericanZip("99801")
                .applyButtonClick()
                .clickContinue()
                .checkAmericanAddress();
        Assert.assertEquals(shouldBeAmericanAddress, "Juneau 99801" + "\u200C"
                , "Provided address is wrong!");
    }

    @Test
    public void verifyIfPolandIsPresentInDropDownTest() {
        String shouldBePoland = amazonPage
                .openAmazonPage()
                .goingToDeliverLogo()
                .dropDownPage()
                .clickOnDropDownForPoland()
                .getPolandAsText();
        Assert.assertEquals(shouldBePoland, "Poland"
                , "This is not Poland!");
    }

    @Test
    public void verifyShippingAddressToSelectedCountryTest() {
        String shouldBeSpain = amazonPage
                .openAmazonPage()
                .goingToDeliverLogo()
                .dropDownPage()
                .clickOnDropDownForSpain()
                .clickToSelectSpain()
                .clickOnDoneButton()
                .clickOnKeyboardImage()
                .clickOnFirstElement()
                .getSpainAsText();
        Assert.assertEquals(shouldBeSpain, "No Import Fees Deposit & $12.10 Shipping to Spain"
                , "Shipping address is not settled to Spain");
    }
}
