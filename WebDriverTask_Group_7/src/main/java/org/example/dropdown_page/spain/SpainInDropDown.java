package org.example.dropdown_page.spain;

import com.codeborne.selenide.Selenide;
import org.example.verifying_address.DoneButton;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SpainInDropDown {
    private static final By SPAIN = By.id("GLUXCountryList_209");

    public DoneButton clickToSelectSpain(){
        $(SPAIN).contextClick();
        return new DoneButton();
    }
}
