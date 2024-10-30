package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.ReportsPage;
import com.cutanddry.qa.pages.RewardsPage;

public class Rewards {
    static RewardsPage rewardsPage = new RewardsPage();

    public static boolean isUserNavigatedToRewards(){
        return rewardsPage.isRewardsTextDisplayed();
    }
}
