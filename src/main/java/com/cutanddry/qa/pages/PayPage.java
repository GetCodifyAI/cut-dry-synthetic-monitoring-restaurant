package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class PayPage extends LoginPage{
    By txt_pay = By.xpath("//li[contains(text(),'Pay')]");
    By tb_outstanding =By.xpath("//a[@role='tab' and text()='Outstanding']");
    By tb_paid =By.xpath("//a[@role='tab' and text()='Paid']");
    By txt_invoiceID = By.xpath("//thead/tr/th[normalize-space()='Invoice ID']");
    By txt_paymentID = By.xpath("//thead/tr/th[normalize-space()='Payment ID']");

    public boolean isPayTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_pay);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_pay);
    }
    public void clickOnOutstanding() {
        distributorUI.waitForVisibility(tb_outstanding);
        distributorUI.click(tb_outstanding);
    }
    public void clickOnPaid() {
        distributorUI.waitForVisibility(tb_paid);
        distributorUI.click(tb_paid);
    }
    public boolean isOutstandingBtnSelected(){
        distributorUI.waitForVisibility(txt_invoiceID);
        return distributorUI.isDisplayed(txt_invoiceID);
    }
    public boolean isPaidBtnSelected(){
        distributorUI.waitForVisibility(txt_paymentID);
        return distributorUI.isDisplayed(txt_paymentID);
    }
}
