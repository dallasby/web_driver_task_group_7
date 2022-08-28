package org.example.verifying_address;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DoneButton {
    private static final By CLICK_ON_DONE_BUTTON = By.xpath("//*[@id=\"a-popover-1\"]/div/div[2]/span/span/span/button");

    public Keyboard clickOnDoneButton() {
        $(CLICK_ON_DONE_BUTTON).contextClick();
        return new Keyboard();
    }
}
