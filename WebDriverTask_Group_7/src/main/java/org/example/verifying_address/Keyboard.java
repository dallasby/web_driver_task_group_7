package org.example.verifying_address;

import com.codeborne.selenide.Selenide;
import org.example.dropdown_page.spain.FirstElementInKeyboardDropDown;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Keyboard {
    private static final By CLICK_ON_KEYBOARD = By.xpath("//img[contains(@alt,\"Keyboards\")]");

    public FirstElementInKeyboardDropDown clickOnKeyboardImage() {
        $(CLICK_ON_KEYBOARD).click();
        Selenide.refresh();
        return new FirstElementInKeyboardDropDown();
    }
}
