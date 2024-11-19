package com.cutanddry.qa.pages;

import org.openqa.selenium.By;
import org.testng.SkipException;

public class OrdersPage extends LoginPage{
    By txt_orders = By.xpath("//div[contains(text(),'Order Guide')]");
    String btn_placeOrder = "//div[contains(text(), 'NAME')]";
    By txt_editOrder = By.xpath("//h2[contains(text(),'Edit Existing Order')]");

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
    public boolean isEditExistingOrderDisplayed() {
        return distributorUI.isDisplayed(txt_editOrder);
    }
    public static void testAbort() {
        throw new SkipException("Test skipped");
    }
}
