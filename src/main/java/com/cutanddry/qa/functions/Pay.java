package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.PayPage;

public class Pay {
    static PayPage payPage = new PayPage();

    public static boolean isUserNavigatedToPay(){
        return payPage.isPayTextDisplayed();
    }
    public static void clickOnOutstanding(){
        payPage.clickOnOutstanding();
    }
    public static void clickOnPaid(){
        payPage.clickOnPaid();
    }

    public static boolean isOutstandingBtnSelected(){
        return payPage.isOutstandingBtnSelected();
    }
    public static boolean isPaidBtnSelected(){
        return payPage.isPaidBtnSelected();
    }

}
