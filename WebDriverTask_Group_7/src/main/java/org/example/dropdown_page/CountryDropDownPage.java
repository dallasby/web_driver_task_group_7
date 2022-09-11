package org.example.dropdown_page;

import org.example.dropdown_page.spain.SpainInDropDown;
import org.example.dropdown_page.poland.PolandAsText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CountryDropDownPage {
    private static final By CLICK_ON_DROPDOWN = By.id("GLUXCountryListDropdown");

    public PolandAsText clickOnDropDownForPoland() {
        $(CLICK_ON_DROPDOWN).click();
        return new PolandAsText();
    }

    public SpainInDropDown clickOnDropDownForSpain() {
        $(CLICK_ON_DROPDOWN).click();
        return new SpainInDropDown();
    }
}
