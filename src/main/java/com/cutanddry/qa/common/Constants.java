package com.cutanddry.qa.common;

public class Constants {
    public final static String PROJECT_KEY = System.getProperty("project.key","DOT");
    public final static String CYCLE_KEY = System.getProperty("cycle.key","DOT-CY-");
    public static boolean CREATE_CYCLE = Boolean.parseBoolean(System.getProperty("create.cycle","false"));
    public static String BROWSER_NAME = System.getProperty("test.browser", "chrome");
    public static boolean RUN_HEADLESS = Boolean.parseBoolean(System.getProperty("run.headless", "false"));
    public static String TEST_ENV = System.getProperty("test.env", "prod");
    public static String MAIN_URL = baseDomain();
    public static String SEC_URL = secDomain();
    public static String NODE_EXPLORER = "https://app-uat.staging.cutanddry.com/admin";
    public static String BASE_URI = "https://supplier-uat.staging.cutanddry.com/GraphQLController";
    public static String SLACK_WEBHOOK = "https://hooks.slack.com/services/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";
    public static String CONFIG_SUPPLIER = "https://app-uat.staging.cutanddry.com/internaltools/configure-supplier";
    public static String PROD_LOGIN_AS = "https://internal.cutanddry.com/internaltools/loginas";

    //  https://hooks.slack.com/services/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 //group - synthetic-mon-alerts

    private static String baseDomain() {
        if (TEST_ENV.equalsIgnoreCase("UAT")){
            MAIN_URL = "https://app-"+TEST_ENV+".staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("PROD")){
            MAIN_URL = "https://app.cutanddry.com/";
        }
        return MAIN_URL;
    }
    private static String secDomain() {
        if (TEST_ENV.equalsIgnoreCase("UAT")){
            SEC_URL = "https://supplier-"+TEST_ENV+".staging.cutanddry.com/";
        } else if (TEST_ENV.equalsIgnoreCase("PROD")){
            SEC_URL = "https://supplier.cutanddry.com/";
        }
        return SEC_URL;
    }
}
