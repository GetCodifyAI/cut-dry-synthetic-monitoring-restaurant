package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class UsersPage extends LoginPage{
    By txt_users = By.xpath("//h2[contains(text(),'Team')]");

    public boolean isUsersTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_users);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_users);
    }
}
