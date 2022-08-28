package org.example.pageobject;

import com.codeborne.selenide.Selenide;
import org.example.dropdown_page.spain.SpainAsText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FirstElementInKeyboardDropDown {
    private static final By CLICK_ON_FIRST_ELEMENT =
            By.xpath("//img[contains(@alt,'Sponsored Ad - Fiodio Rainbow Membrane Gaming Keyboard, Quiet Wired Computer Keyboard, 104 Silent Keys, 26 Anti-Ghosting K...')]");

    public SpainAsText clickOnFirstElement() {
        $(CLICK_ON_FIRST_ELEMENT).click();
        return new SpainAsText();
    }
}
