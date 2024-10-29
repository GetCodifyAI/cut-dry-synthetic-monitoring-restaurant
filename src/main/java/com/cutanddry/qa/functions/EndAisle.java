package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.EndAislePage;

public class EndAisle {
    static EndAislePage endlAislePage = new EndAislePage();

    public static boolean isUserNavigatedToEndlAisle(){
        return endlAislePage.isEndlAisleTextDisplayed();
    }
}
