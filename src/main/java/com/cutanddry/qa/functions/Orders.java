package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.OrdersPage;

import static com.cutanddry.qa.functions.Customer.customersPage;

public class Orders {
    static OrdersPage ordersPage = new OrdersPage();

    public static boolean isUserNavigatedToOrderGuide(){
        return ordersPage.isOrderGuideTextDisplayed();
    }
    public static void navigateToOrderGuide(String name) throws InterruptedException {
        ordersPage.clickOnPlaceOrder(name);
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
       }
    }
}
