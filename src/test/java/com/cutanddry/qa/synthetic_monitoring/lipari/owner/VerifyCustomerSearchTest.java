package com.cutanddry.qa.synthetic_monitoring.lipari.owner;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Orders;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyCustomerSearchTest extends TestBase {
    static User user;
    static String DP = "Anna Geller Customer";
    static String itemCode = "100500";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readLipariUserLogin();
    }

    @Test
    public void VerifyCustomerSearch() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.logIntoLipariRestaurantProd(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToRestaurantDashboard(),"login error");
        Login.navigateToLipariPortal(DP);
        Dashboard.navigateToOrders();
        Customer.selectOrderGuideViewFromMoreOptions();
//        Orders.navigateToOrderGuide(DPName);
        softAssert.assertTrue(Orders.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.searchItemOnOrderGuide(itemCode);
        softAssert.assertTrue(Customer.getItemDetailsFirstRow().contains(itemCode),"item mismatch");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
