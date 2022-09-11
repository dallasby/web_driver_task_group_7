package org.example.dropdown_page.poland;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PolandAsText {
    private static final By POLAND = By.id("GLUXCountryList_178");

    public String getPolandAsText() {
        return $(POLAND).getText();
    }
}
