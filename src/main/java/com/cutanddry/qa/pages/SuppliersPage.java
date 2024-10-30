package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class SuppliersPage extends LoginPage{
    By txt_suppliers = By.xpath("//div[contains(text(),'Suppliers')]");

    public boolean isSuppliersTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_suppliers);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_suppliers);
    }
}
