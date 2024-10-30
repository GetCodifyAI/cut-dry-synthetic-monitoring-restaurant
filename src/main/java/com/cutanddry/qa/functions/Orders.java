package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.OrdersPage;

public class Orders {
    static OrdersPage ordersPage = new OrdersPage();

    public static boolean isUserNavigatedToOrderGuide(){
        return ordersPage.isOrderGuideTextDisplayed();
    }
    public static void navigateToOrderGuide(String name) {
        ordersPage.clickOnPlaceOrder(name);
    }
}
