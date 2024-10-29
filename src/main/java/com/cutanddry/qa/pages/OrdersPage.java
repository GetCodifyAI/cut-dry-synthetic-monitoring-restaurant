package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class OrdersPage extends LoginPage{
    By txt_orders = By.xpath("//div[contains(text(),'Order Guide')]");

    public boolean isOrdersTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_orders);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_orders);
    }
}
