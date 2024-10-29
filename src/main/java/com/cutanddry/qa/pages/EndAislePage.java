package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class EndAislePage extends LoginPage{
    By txt_endAisle = By.xpath("//h2[contains(text(),'Endless Aisle Catalog')]");

    public boolean isEndlAisleTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_endAisle);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_endAisle);
    }
}
