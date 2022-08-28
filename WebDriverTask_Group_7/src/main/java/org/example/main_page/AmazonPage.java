package org.example.main_page;

import org.example.main_page.helper.LogoClick;
import org.example.main_page.interfaces.IOpenPage;

import static com.codeborne.selenide.Selenide.open;

public class AmazonPage implements IOpenPage {
    @Override
    public AmazonPage openAmazonPage() {
        open("https://www.amazon.com/");
        return this;
    }

    public DeliverToLogo goingToDeliverLogo() {
        LogoClick.clickOnLogoDeliverTo();
        return new DeliverToLogo();
    }
}
