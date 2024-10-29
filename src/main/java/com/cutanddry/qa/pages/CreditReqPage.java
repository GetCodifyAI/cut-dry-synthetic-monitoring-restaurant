package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class CreditReqPage extends LoginPage{
    By txt_creditReq = By.xpath("//h3[contains(text(),'Credit Requests')]");

    public boolean isCreditReqTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_creditReq);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_creditReq);
    }
}
