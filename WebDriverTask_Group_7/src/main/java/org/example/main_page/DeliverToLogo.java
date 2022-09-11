package org.example.main_page;

import org.example.american_address.main_page.BasePageForAmerica;
import org.example.dropdown_page.CountryDropDownPage;

public class DeliverToLogo {
    public BasePageForAmerica pageForAmerica() {
        return new BasePageForAmerica();
    }

    public CountryDropDownPage dropDownPage() {
        return new CountryDropDownPage();
    }
}
