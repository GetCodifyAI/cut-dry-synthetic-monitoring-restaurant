package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class PayPage extends LoginPage{
    By txt_pay = By.xpath("//li[contains(text(),'Pay')]");
    By tb_outstanding =By.xpath("//a[contains(text(), 'Outstanding')]");
    By tb_paid =By.xpath("//a[contains(text(), 'Paid')]");
    By txt_invoiceID = By.xpath("//thead/tr/th[normalize-space()='Invoice ID']");
    By txt_paymentID = By.xpath("//thead/tr/th[normalize-space()='Payment ID']");
    By txt_noOutstanding = By.xpath("//div[contains(text(), 'Invoices ready to be paid will show up here')]");
    By txt_noPaid = By.xpath("//div[contains(text(), 'Paid invoices will show up here.')]");

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
        if (distributorUI.isDisplayed(txt_noOutstanding)){
            return true;
        } else if (distributorUI.isDisplayed(txt_invoiceID)) {
            return true;
        }
        else return false;
    }
    public boolean isPaidBtnSelected() {
        if (distributorUI.isDisplayed(txt_noPaid)) {
            return true;
        } else if (distributorUI.isDisplayed(txt_invoiceID)) {
            return true;
        } else return false;
    }
}
