package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class DashboardPage extends LoginPage{
    By txt_dashboard = By.xpath("//li[contains(text(),'Dashboard')]");
    By btn_customers = By.xpath("//a[@data-tip='Customers']");
    By btn_boost = By.xpath("//a[@data-tip='Boost']");
    By btn_chat = By.xpath("//a[@data-tip='Chat']");
    By txt_dashboard_restaurant = By.xpath("//div[text()='Place Order']");
    By btn_restaurant_chat = By.xpath("//div[contains(text(),'Chat')]");
    By btn_catalog = By.xpath("//a[@data-tip='View Catalog']");
    By btn_settings = By.xpath("//a[@role='button' and contains(text(), 'Settings')]");
    By btn_orderSettings = By.xpath("//div[@arrowprops]//a[text()='Orders']");
    By btn_teamSettings = By.xpath("//div[@arrowprops]//a[text()='Team']");
    By btn_users = By.xpath("//a[@data-tip='Team']");
    By txt_home = By.xpath("//li[contains(text(),'Home')]");
    By btn_orderDesk = By.xpath("//a[contains(text(),'Order Desk')]");
    By btn_viewOrders = By.xpath("//a[contains(text(),'Orders')]");
    By txt_all = By.xpath("//div[text()='All']");
    By txt_lastDays = By.xpath("(//div[text()='Last 30 Days'])[1]");
    By lbl_salespersonDropdown = By.xpath("(//div[contains(@class, 'css-1uccc91-singleValue')])[1]");
    By lbl_durationDropdown = By.xpath("(//div[contains(@class, 'css-1uccc91-singleValue')])[2]");
    String txt_salesperson = "//div[text()='NAME']";
    String txt_days = "//div[text()='DAYS']";
    By txt_teamStanding = By.xpath("//h4[contains(text(), 'Team Standings')]");
    By txt_totalOnlineOrders = By.xpath("//tr[td[contains(text(), 'Total')]]/td[3]");
    By txt_totalOnlineRev = By.xpath("//tr[td[contains(text(), 'Total')]]/td[4]");
    By txt_totalTimeSaved = By.xpath("//tr[td[contains(text(), 'Total')]]/td[5]");
    By btn_history = By.xpath("//a[@data-tip='Order History']");
    By btn_drafts  =By.xpath("//a[@data-tip='View Drafts']");
    By btn_track = By.xpath("//a[@role='button' and contains(text(), 'Track')]");
    By btn_trackResources = By.xpath("//div[@arrowprops]//a[text()='Resources']");
    By btn_trackRoutes = By.xpath("//div[@arrowprops]//a[text()='Routes']");
    By btn_trackMonitoring = By.xpath("//div[@arrowprops]//a[text()='Monitoring']");
    By btn_trackNotifications = By.xpath("//div[@arrowprops]//a[text()='Notifications']");
    By btn_pay  =By.xpath("//a[@data-tip='Payments']");
    By btn_reports  =By.xpath("//a[@data-tip='Reports']");
    By btn_trackSettings = By.xpath("//div[@arrowprops]//a[text()='Track']");
    By btn_profSettings = By.xpath("//div[@arrowprops]//a[text()='Profile']");
    By btn_companySettings = By.xpath("//div[@arrowprops]//a[text()='Company']");
    By btn_billingSettings = By.xpath("//div[@arrowprops]//a[text()='Billing']");
    By btn_support = By.xpath("//a[@data-tip='Support']");
    By btn_tracker  =By.xpath("//a[@data-tip='Tracker']");
    By btn_endlAisle  =By.xpath("//a[@data-tip='Endless Aisle']");
    By btn_creditReq  =By.xpath("//a[@data-tip='Credit Requests']");
    By btn_showcase = By.xpath("//a[contains(@data-tip,'Cut+Dry Product Showcase')]");

    public boolean isDashboardTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_dashboard);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_dashboard);
    }
    public void clickOnCustomers(){
        distributorUI.click(btn_customers);
    }
    public void clickOnBoost(){
        distributorUI.click(btn_boost);
    }
    public void clickOnChat(){
        distributorUI.click(btn_chat);
    }
    public boolean isRestaurantDashboardTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_dashboard_restaurant);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_dashboard_restaurant);
    }
    public void clickOnRestaurantChat(){
        distributorUI.click(btn_restaurant_chat);
    }
    public void clickOnCatalog(){
        distributorUI.click(btn_catalog);
    }
    public void clickOnOrderSettings(){
        distributorUI.scrollToElement(btn_settings);
        distributorUI.clickUsingJavaScript(btn_settings);
        distributorUI.hoverOverElement(btn_orderSettings);
        distributorUI.click(btn_orderSettings);
    }
    public void clickOnTeamSettings(){
        distributorUI.scrollToElement(btn_settings);
        distributorUI.clickUsingJavaScript(btn_settings);
        distributorUI.hoverOverElement(btn_teamSettings);
        distributorUI.click(btn_teamSettings);
    }
    public boolean isWhiteLabelDashboardTextDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_home);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_home);
    }
    public void clickOnUsers(){
        distributorUI.waitForVisibility(btn_users);
        distributorUI.click(btn_users);
    }
    public void clickOnOrders(){
        distributorUI.click(btn_viewOrders);
    }
    public void clickOnOrderDesk(){
        distributorUI.click(btn_orderDesk);
    }
    public boolean isDashboardDefaultValuesDisplayed(){
        try {
            distributorUI.isDisplayed(txt_all);
            distributorUI.isDisplayed(txt_lastDays);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_all) && distributorUI.isDisplayed(txt_lastDays);
    }
    public void selectSalesperson(String name){
        distributorUI.click(lbl_salespersonDropdown);
        distributorUI.waitForVisibility(By.xpath(txt_salesperson.replace("NAME", name)));
        distributorUI.click(By.xpath(txt_salesperson.replace("NAME", name)));
    }
    public void selectDuration(String days){
        distributorUI.click(lbl_durationDropdown);
        distributorUI.waitForVisibility(By.xpath(txt_days.replace("DAYS", days)));
        distributorUI.click(By.xpath(txt_days.replace("DAYS", days)));
    }
    public boolean isDashboardSalespersonChanged(String name){
        try {
            distributorUI.isDisplayed(By.xpath(txt_salesperson.replace("NAME", name)));
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(By.xpath(txt_salesperson.replace("NAME", name)));
    }
    public boolean isDashboardDurationChanged(String days){
        try {
            distributorUI.isDisplayed(By.xpath(txt_days.replace("DAYS", days)));
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(By.xpath(txt_days.replace("DAYS", days)));
    }
    public boolean isTeamStandingsDisplayed(){
        try {
            distributorUI.waitForVisibility(txt_teamStanding);
            distributorUI.isDisplayed(txt_teamStanding);
        } catch (Exception e){
            return false;
        }
        return distributorUI.isDisplayed(txt_teamStanding);
    }
    public String[] getTotalSumDisplayed(){
        String[] totals = new String[3];

        totals[0] = distributorUI.getText(txt_totalOnlineOrders);
        totals[1] = distributorUI.getText(txt_totalOnlineRev);
        totals[2] = distributorUI.getText(txt_totalTimeSaved);

        return totals;
    }
    public void clickOnHistory(){
        distributorUI.click(btn_history);
    }
    public void clickOnDrafts(){
        distributorUI.click(btn_drafts);
    }

    public void clickOnTrackResources(){
        distributorUI.scrollToElement(btn_track);
        distributorUI.clickUsingJavaScript(btn_track);
        distributorUI.hoverOverElement(btn_trackResources);
        distributorUI.click(btn_trackResources);
    }
    public void clickOnTrackRoutes(){
        distributorUI.scrollToElement(btn_track);
        distributorUI.clickUsingJavaScript(btn_track);
        distributorUI.hoverOverElement(btn_trackRoutes);
        distributorUI.click(btn_trackRoutes);
    }
    public void clickOnTrackMonitoring(){
        distributorUI.scrollToElement(btn_track);
        distributorUI.clickUsingJavaScript(btn_track);
        distributorUI.hoverOverElement(btn_trackMonitoring);
        distributorUI.click(btn_trackMonitoring);
    }
    public void clickOnTrackNotifications(){
        distributorUI.scrollToElement(btn_track);
        distributorUI.clickUsingJavaScript(btn_track);
        distributorUI.hoverOverElement(btn_trackNotifications);
        distributorUI.click(btn_trackNotifications);
    }
    public void clickOnPay(){
        distributorUI.click(btn_pay);
    }
    public void clickOnReports(){
        distributorUI.click(btn_reports);
    }
    public void clickOnBillingSettings(){
        distributorUI.scrollToElement(btn_settings);
        distributorUI.clickUsingJavaScript(btn_settings);
        distributorUI.hoverOverElement(btn_billingSettings);
        distributorUI.click(btn_billingSettings);
    }
    public void clickOnCompanySettings(){
        distributorUI.scrollToElement(btn_settings);
        distributorUI.clickUsingJavaScript(btn_settings);
        distributorUI.hoverOverElement(btn_companySettings);
        distributorUI.click(btn_companySettings);
    }
    public void clickOnTrackSettings(){
        distributorUI.scrollToElement(btn_settings);
        distributorUI.clickUsingJavaScript(btn_settings);
        distributorUI.hoverOverElement(btn_trackSettings);
        distributorUI.click(btn_trackSettings);
    }
    public void clickOnProfileSettings(){
        distributorUI.scrollToElement(btn_settings);
        distributorUI.clickUsingJavaScript(btn_settings);
        distributorUI.hoverOverElement(btn_profSettings);
        distributorUI.click(btn_profSettings);
    }
    public void clickOnSupport(){
        String url = distributorUI.getText(btn_support,"href");
        distributorUI.navigateToURL(url);
    }
    public void clickOnTracker(){
        distributorUI.click(btn_tracker);
    }
    public void clickOnEndlessAisle(){
        distributorUI.click(btn_endlAisle);
    }
    public void clickOnCreditRequest(){
        distributorUI.click(btn_creditReq);
    }
    public void clickOnShowCase(){
        distributorUI.click(btn_showcase);
    }
}
