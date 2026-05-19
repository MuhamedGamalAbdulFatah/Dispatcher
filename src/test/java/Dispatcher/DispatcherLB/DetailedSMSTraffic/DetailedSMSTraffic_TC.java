package Dispatcher.DispatcherLB.DetailedSMSTraffic;

import Dispatcher.DispatcherLB.SMSTrafficDistribution.SMSTraffic_Page;
import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DetailedSMSTraffic_TC extends TestBase_TC {

    LogIn_Page login;
    DetailedSMSTraffic_Page detailedsmstraffic;

    @BeforeTest
    public void SignIn() throws InterruptedException {
        login = new LogIn_Page(driver);

        login.EnterUserName("CreditAgricole@cloudcom.io");
        login.EnterPassword("Admin@123");
        login.ClickRememberMe();
        login.ClickOnLoginButton();

        Thread.sleep(50000);

        detailedsmstraffic = new DetailedSMSTraffic_Page(driver);


    }
    @Test
    public void TC_01_AssertionOnErrorDate() throws InterruptedException, IOException {
        detailedsmstraffic = new DetailedSMSTraffic_Page(driver);

        detailedsmstraffic
                .ClickOnDetailedSMSTraffic()
                .TypeOnFromDate("13/01/2027")
                .TypeOnToDate("05/05/2026");
        Thread.sleep(3000);
        detailedsmstraffic.ClickOnSubmit();
        Thread.sleep(3000);

        driver.verifyThat().element(detailedsmstraffic.Table).exists().perform();
    }

    @Test
    public void TC_02_ExportedCsvRowsShouldMatchTableRows() throws InterruptedException, IOException {
        detailedsmstraffic = new DetailedSMSTraffic_Page(driver);

        detailedsmstraffic
                .TypeOnFromDate("01/01/2026")
                .TypeOnToDate("04/05/2026");

        Thread.sleep(10000);


        detailedsmstraffic.ClickOnSubmit();

        Thread.sleep(3000);

        detailedsmstraffic.ClickOnExport();
        Thread.sleep(5000);

        String downloadDir = "D:\\DispatcherProject\\target\\downloadedFiles\\";
        String fileName = "detailed_sms_traffic_report.csv";
        String fullPath = downloadDir + fileName;

        By info = By.id("DataTables_SMSTrafficDistribution_info"); // غيّر الـ id حسب tableId بتاعك
        String text = driver.element().getText(info).trim();

        String totalStr = text.replaceAll(".*\\bof\\s+([0-9,]+)\\s+entries\\b.*", "$1");
        int total = Integer.parseInt(totalStr.replace(",", ""));



        int csvRowsCount = detailedsmstraffic.getCsvRowsCount(fullPath);

        Assert.assertEquals(
                csvRowsCount,
                total,
                "CSV rows count does not match table rows count"
        );

        System.out.println("Table Rows Count = " + total);
        System.out.println("CSV Rows Count = " + csvRowsCount);
    }
    @Test
    public void TC_03_ActionWorkFine() throws InterruptedException, IOException {
        detailedsmstraffic = new DetailedSMSTraffic_Page(driver);

        Thread.sleep(3000);

        detailedsmstraffic.ClickOnAction();
        driver.element().assertThat(detailedsmstraffic.Table).isVisible();
    }

}