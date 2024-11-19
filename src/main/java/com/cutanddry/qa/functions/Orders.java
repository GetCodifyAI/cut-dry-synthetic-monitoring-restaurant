package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.OrdersPage;
import org.testng.SkipException;

import static com.cutanddry.qa.functions.Customer.customersPage;

public class Orders {
    static OrdersPage ordersPage = new OrdersPage();

    public static boolean isUserNavigatedToOrderGuide(){
        return ordersPage.isOrderGuideTextDisplayed();
    }
    public static void navigateToOrderGuide(String name) throws InterruptedException {
        ordersPage.clickOnPlaceOrder(name);
        if (ordersPage.isEditExistingOrderDisplayed()) {
            OrdersPage.testAbort();
        }
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
       }
    }
}
