package com.cutanddry.qa.synthetic_monitoring.lipari.owner;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Settings;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifySettingsProfileTest extends TestBase {
    static User user;
    static String DP = "Anna Geller Customer";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readLipariUserLogin();
    }

    @Test
    public void VerifyProfileSettings() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.logIntoLipariRestaurantProd(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToRestaurantDashboard(),"login error");
        Login.navigateToLipariPortal(DP);
        Dashboard.navigateToProfileSettings();
        softAssert.assertTrue(Settings.isProfileSettingsTextDisplayed(),"navigation to profile settings error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
