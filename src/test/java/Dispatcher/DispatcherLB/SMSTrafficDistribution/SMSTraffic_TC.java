package Dispatcher.DispatcherLB.SMSTrafficDistribution;

import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SMSTraffic_TC extends TestBase_TC {

    LogIn_Page login;
    SMSTraffic_Page smsTrafficPage;

    @BeforeTest
    public void SignIn() throws InterruptedException {
        login = new LogIn_Page(driver);

        login.EnterUserName("CreditAgricole@cloudcom.io");
        login.EnterPassword("Admin@123");
        login.ClickRememberMe();
        login.ClickOnLoginButton();

        Thread.sleep(20000);

        smsTrafficPage = new SMSTraffic_Page(driver);


    }

    @Test
    public void TC_01_ExportedCsvRowsShouldMatchTableRows() throws InterruptedException, IOException {
        smsTrafficPage = new SMSTraffic_Page(driver);

        smsTrafficPage
                .ClickOnSMSTraffic()
                .TypeOnFromDate("01/01/2026")
                .TypeOnToDate("04/05/2026");

        driver.element().click(smsTrafficPage.All1);
        driver.element().click(smsTrafficPage.All2);

        smsTrafficPage.ClickOnSubmit();

        Thread.sleep(3000);

        int tableRowsCount = smsTrafficPage.GetTableRowsCount();
        Assert.assertTrue(tableRowsCount > 0, "Table has no rows");
        smsTrafficPage.ClickOnExport();
        Thread.sleep(5000);

        String downloadDir = "D:\\DispatcherProject\\target\\downloadedFiles\\";
        String fileName = "sms_traffic_distribution_report.csv";
        String fullPath = downloadDir + fileName;




        int csvRowsCount = smsTrafficPage.getCsvRowsCount(fullPath);

        Assert.assertEquals(
                csvRowsCount,
                tableRowsCount,
                "CSV rows count does not match table rows count"
        );

        System.out.println("Table Rows Count = " + tableRowsCount);
        System.out.println("CSV Rows Count = " + csvRowsCount);
    }
}