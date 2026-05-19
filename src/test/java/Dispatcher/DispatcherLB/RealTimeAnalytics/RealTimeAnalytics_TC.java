package Dispatcher.DispatcherLB.RealTimeAnalytics;

import Dispatcher.DispatcherLB.SMSTrafficDistribution.SMSTraffic_Page;
import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class RealTimeAnalytics_TC extends TestBase_TC {

    LogIn_Page login;
    RealTimeAnalytics_Page RealTime;

    @BeforeTest
    public void SignIn() throws InterruptedException {
        login = new LogIn_Page(driver);

        login.EnterUserName("CreditAgricole@cloudcom.io");
        login.EnterPassword("Admin@123");
        login.ClickRememberMe();
        login.ClickOnLoginButton();

        Thread.sleep(30000);

        RealTime = new RealTimeAnalytics_Page(driver);


    }
    @Test (priority = 1)
    public void TC_01_RealTimeAnalyticsNotWorksFineAndFalse() throws InterruptedException {
        RealTime = new RealTimeAnalytics_Page(driver);

        RealTime
                .ClickOnRealTimeAnalytics()
                .TypeOnFromDate("13/01/2027")
                .TypeOnToDate("05/05/2026");
        Thread.sleep(3000);
        RealTime.ClickOnSubmit();
        Thread.sleep(3000);
        driver.element().assertThat(RealTime.DateError).isVisible();

    }


    @Test (priority = 2)
    public void TC_02_RealTimeAnalyticsWorksFineAndTure() throws InterruptedException {
        RealTime = new RealTimeAnalytics_Page(driver);

        RealTime
                .TypeOnFromDate("01/01/2026")
                .TypeOnToDate("05/05/2026");
        Thread.sleep(15000);
        RealTime.ClickOnSubmit();
        Thread.sleep(3000);

        double total = RealTime.getSuccessRate() + RealTime.getFailureRate();

        Assert.assertTrue(Math.abs(total - 100.00) < 00.02, "Success + Failure should be ~ 100%");
    }
}