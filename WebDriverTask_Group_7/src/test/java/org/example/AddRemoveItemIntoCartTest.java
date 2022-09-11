package org.example;

import org.example.pageobject.pages.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddRemoveItemIntoCartTest extends BaseTest {

    private AddToCartConfirmationPage confirmationAddPage;

    private void addToCartTestMethod(WebDriver webDriver) {
        webDriver.manage().deleteAllCookies();

        HomePage amazonPage = new HomePage(webDriver);
        this.confirmationAddPage = amazonPage.open()
                .openCategory()
                .openProduct()
                .addProductToCart();
    }

    @Test
    public void addItemIntoCart() {

        addToCartTestMethod(webDriver);

        Assert.assertEquals(confirmationAddPage.checkIfAddedToCartText(), "Added to Cart",
                "Item not added to cart");

        Assert.assertEquals(confirmationAddPage.checkIfAddedToCartCount(), "1",
                "Item not added to cart");
    }

    @Test
    public void removeItemFromCart() {

        addToCartTestMethod(webDriver);

        RemoveFromCartConfirmationPage confirmationRemovalPage = this.confirmationAddPage
                .openCart()
                .removeProduct();

        Assert.assertEquals(confirmationRemovalPage.checkIfRemovedFromCartText(), "Your Amazon Cart is empty.",
                "Item not removed from cart");

        Assert.assertEquals(confirmationRemovalPage.checkIfRemovedFromCartPrice(), "$0.00",
                "Item not removed from cart");
    }
}
