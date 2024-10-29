package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.UsersPage;

public class Users {
    static UsersPage userPage = new UsersPage();

    public static boolean isUserNavigatedToUsers(){
        return userPage.isUsersTextDisplayed();
    }
}
