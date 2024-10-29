package com.cutanddry.qa.functions;


import com.cutanddry.qa.pages.CreditReqPage;

public class CreditReq {
    static CreditReqPage creditReqPage = new CreditReqPage();

    public static boolean isUserNavigatedToCreditRequest(){
        return creditReqPage.isCreditReqTextDisplayed();
    }
}
