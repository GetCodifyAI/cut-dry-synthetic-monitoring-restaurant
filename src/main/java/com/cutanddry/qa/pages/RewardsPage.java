package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class RewardsPage extends LoginPage{
    By txt_rewards = By.xpath("//div[contains(text(),'Rewards')]");

    public boolean isRewardsTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_rewards);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_rewards);
    }
}
