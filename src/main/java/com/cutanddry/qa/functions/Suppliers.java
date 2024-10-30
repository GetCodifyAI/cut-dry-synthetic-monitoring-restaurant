package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.SuppliersPage;

public class Suppliers {
    static SuppliersPage supplierPage = new SuppliersPage();

    public static boolean isUserNavigatedToSuppliers(){
        return supplierPage.isSuppliersTextDisplayed();
    }
}
