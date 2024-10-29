package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.ShowCasePage;

public class ShowCase {
    static ShowCasePage showCasePage = new ShowCasePage();

    public static boolean isNavigatedToShowCase(){
        return showCasePage.isProductShowcaseTxtDisplayed();
    }

    public static void searchProductInProductSearchBar(String ProductName){
        showCasePage.searchInProductSearchBar(ProductName);
    }

    public static boolean isShowcaseItemDisplayed(String name){
        return showCasePage.isShowcaseItemDisplayed(name);
    }

}
