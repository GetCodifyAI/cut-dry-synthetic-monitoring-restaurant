package com.cutanddry.qa.synthetic_monitoring.kk.owner;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Chat;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheChatTest extends TestBase {
    static User user;
    static String DP = "103170655";
    static String DPName= "K&K International, Inc.";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test
    public void VerifyTheChat() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.logIntoRestaurantProd(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToRestaurantDashboard(),"login error");
        Login.navigateToLoginAsPortal(DP);
        Dashboard.navigateToChat();
        Chat.clickOnCustomerChat(DPName);
        softAssert.assertTrue(Chat.isUserNavigatedToChat(),"navigation error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
