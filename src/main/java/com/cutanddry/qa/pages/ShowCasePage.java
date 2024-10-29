package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class ShowCasePage extends LoginPage {
    By productShowcaseTxt = By.xpath("//h1[contains(text(),'Cut+Dry Product Showcase')]");
    By productSearchBar = By.xpath("//input[@id='order_flow_search']");
    String txt_itemName =  "//div[contains(text(), 'NAME')]";

    public boolean isProductShowcaseTxtDisplayed(){
        return distributorUI.isDisplayed(productShowcaseTxt);
    }

    public void searchInProductSearchBar(String productName){
        distributorUI.sendKeys(productSearchBar,productName);
    }


    public boolean isShowcaseItemDisplayed(String name){
        distributorUI.waitForVisibility(By.xpath(txt_itemName.replace("NAME", name)));
        return distributorUI.isDisplayed(By.xpath(txt_itemName.replace("NAME", name)));
    }
}
