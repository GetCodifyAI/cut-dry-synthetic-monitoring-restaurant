package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class OrdersPage extends LoginPage{
    By txt_orders = By.xpath("//div[contains(text(),'Order Guide')]");
    String btn_placeOrder = "//div[contains(text(), 'NAME')]";

    public boolean isOrderGuideTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_orders);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_orders);
    }

    public void clickOnPlaceOrder(String name) {
        distributorUI.click(By.xpath(btn_placeOrder.replace("NAME", name)));
    }
}
