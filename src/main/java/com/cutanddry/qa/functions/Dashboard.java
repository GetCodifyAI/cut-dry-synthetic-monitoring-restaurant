package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.DashboardPage;

public class Dashboard {
    static DashboardPage dashboardPage = new DashboardPage();

    public static boolean isUserNavigatedToDashboard(){
        return dashboardPage.isDashboardTextDisplayed();
    }

    public static void navigateToCustomers() {
        dashboardPage.clickOnCustomers();
    }
    public static void navigateToBoost() {
        dashboardPage.clickOnBoost();
    }
    public static void navigateToChat() {
        dashboardPage.clickOnChat();
    }
    public static boolean isUserNavigatedToRestaurantDashboard(){
        return dashboardPage.isRestaurantDashboardTextDisplayed();
    }
    public static void navigateToRestaurantChat() {
        dashboardPage.clickOnRestaurantChat();
    }

    public static void navigateToCatalog() {
        dashboardPage.clickOnCatalog();
    }
    public static void navigateToOrderSettings() {
        dashboardPage.clickOnOrderSettings();
    }
    public static void navigateToTeamSettings() {
        dashboardPage.clickOnTeamSettings();
    }
    public static boolean isUserNavigatedToDashboardWhiteLabel(){
        return dashboardPage.isWhiteLabelDashboardTextDisplayed();
    }
    public static void navigateToUsersWhiteLabel() {
        dashboardPage.clickOnUsers();
    }
    public static void navigateToOrders(){
        dashboardPage.clickOnOrders();
    }
    public static void navigateToOrderDesk(){
        dashboardPage.clickOnOrderDesk();
    }
    public static boolean isDashboardDefaultValuesDisplayed(){
        return dashboardPage.isDashboardDefaultValuesDisplayed();
    }
    public static void selectSalesperson(String name) {
        dashboardPage.selectSalesperson(name);
    }
    public static void selectDuration(String days) {
        dashboardPage.selectDuration(days);
    }
    public static boolean isDashboardSalespersonChanged(String name){
        return dashboardPage.isDashboardSalespersonChanged(name);
    }
    public static boolean isDashboardDurationChanged(String days){
        return dashboardPage.isDashboardDurationChanged(days);
    }
    public static boolean isTeamStandingsDisplayed(){
        return dashboardPage.isTeamStandingsDisplayed();
    }
    public static String[] getTotalSumDisplayed() {
        return dashboardPage.getTotalSumDisplayed();
    }
    public static void navigateToHistory() {
        dashboardPage.clickOnHistory();
    }
    public static void navigateToDrafts() {
        dashboardPage.clickOnDrafts();
    }
    public static void navigateToTrackResources() {
        dashboardPage.clickOnTrackResources();
    }
    public static void navigateToTrackRoutes() {
        dashboardPage.clickOnTrackRoutes();
    }
    public static void navigateToTrackMonitoring() {
        dashboardPage.clickOnTrackMonitoring();
    }
    public static void navigateToTrackNotifications() {
        dashboardPage.clickOnTrackNotifications();
    }
    public static void navigateToPay() {
        dashboardPage.clickOnPay();
    }
    public static void navigateToReports() {
        dashboardPage.clickOnReports();
    }
    public static void navigateToCompanySettings() {
        dashboardPage.clickOnCompanySettings();
    }
    public static void navigateToBillingSettings() {
        dashboardPage.clickOnBillingSettings();
    }
    public static void navigateToTrackSettings() {
        dashboardPage.clickOnTrackSettings();
    }
    public static void navigateToProfileSettings() {
        dashboardPage.clickOnProfileSettings();
    }
    public static void navigateToSupport() {
        dashboardPage.clickOnSupport();
    }
    public static void navigateToTracker() {
        dashboardPage.clickOnTracker();
    }
    public static void navigateToEndlessAisle() {
        dashboardPage.clickOnEndlessAisle();
    }
    public static void navigateToCreditRequest() {
        dashboardPage.clickOnCreditRequest();
    }
    public static void navigateToShowCasePage(){
        dashboardPage.clickOnShowCase();
    }
}
