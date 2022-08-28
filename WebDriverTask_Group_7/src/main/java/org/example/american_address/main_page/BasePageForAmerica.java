package org.example.american_address.main_page;

import org.example.american_address.modules.ApplyButton;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePageForAmerica {
    private static final By ENTER_US_ZIP_CODE = By.id("GLUXZipUpdateInput");

    public ApplyButton settingValueAsAmericanZip(String americanZipAddress) {
        $(ENTER_US_ZIP_CODE).setValue(americanZipAddress);
        return new ApplyButton();
    }
}
