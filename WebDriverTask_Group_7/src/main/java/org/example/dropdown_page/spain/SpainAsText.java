package org.example.dropdown_page.spain;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SpainAsText {
    private static final By SPAIN_AS_TEXT = By.xpath("//*[@id=\"amazonGlobal_feature_div\"]/span[1]");

    public String getSpainAsText() {
        return $(SPAIN_AS_TEXT).getText();
    }
}
