package com.cutanddry.qa.synthetic_monitoring.lipari.employee;

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

public class VerifyCustomerCatalogTest extends TestBase {
    static User user;
    static String DP = "1040306106";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readLipariUserLogin();
    }

    @Test
    public void VerifyCustomerCatalog() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.logIntoLipariRestaurantProd(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToRestaurantDashboard(),"login error");
        Login.navigateToLipariPortal(DP);
        Dashboard.navigateToOrders();
//        Orders.navigateToOrderGuide(DPName);
        softAssert.assertTrue(Orders.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isNavigatedToCatalog(),"catalog navigation error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
