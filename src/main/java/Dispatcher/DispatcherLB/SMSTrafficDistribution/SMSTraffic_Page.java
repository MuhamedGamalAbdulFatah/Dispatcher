package Dispatcher.DispatcherLB.SMSTrafficDistribution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class SMSTraffic_Page {
    SHAFT.GUI.WebDriver driver;
    private final SoftAssert softAssert;
    public SMSTraffic_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }
    By BTN_SMSTrafficReport = By.xpath("//div[@data-i18n=\"SMSTrafficReport\"]");
    By TXT_FromDate = By.xpath("(//input[@class=\"form-control rounded-pill\"])[1]");
    By TXT_ToDate = By.xpath("(//input[@class=\"form-control rounded-pill\"])[2]");
    By LST_SMSTraffic = By.id("smsTraffic");
    By LST_Provider = By.id("provider");

    By BTN_Submit = By.xpath("//button[@type=\"submit\"]");

    By TABLE_SMSTraffic = By.id("DataTables_SMSTrafficReport");
    By ROWS_SMSTraffic = By.xpath("//table[@id='DataTables_SMSTrafficReport']/tbody/tr");
    By BTN_Export = By.id("exportBtn");

    public SMSTraffic_Page SelectSMSTraffic(String S) {
        driver.element().click(LST_SMSTraffic);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
    public By All1 = By.xpath("(//option[text()='All'])[1]");
    public By All2 = By.xpath("(//option[text()='All'])[2]");

    public SMSTraffic_Page SelectProvider(String S) {
        driver.element().click(LST_Provider);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
    public int GetTableRowsCount() {
        driver.element().assertThat(TABLE_SMSTraffic)
                .isVisible()
                .perform();

        int rowsCount = driver.element().getElementsCount(ROWS_SMSTraffic);

        System.out.println("Total Rows Count = " + rowsCount);

        return rowsCount;
    }
    public SMSTraffic_Page ClickOnSMSTraffic()
    {
        driver.element().click(BTN_SMSTrafficReport);
        return this;
    }

    public SMSTraffic_Page TypeOnFromDate(String S)
    {
        driver.element().type(TXT_FromDate , S );
        return this;
    }
    public SMSTraffic_Page TypeOnToDate(String S)
    {
        driver.element().type(TXT_ToDate , S );
        return this;
    }
    public SMSTraffic_Page ClickOnExport()
    {
        driver.element().click(BTN_Export);
        return this;
    }
    public SMSTraffic_Page ClickOnSubmit()
    {
        driver.element().click(BTN_Submit);
        return this;
    }

    public int getCsvRowsCount(String filePath) throws IOException {

        List<String> lines = Files.readAllLines(Path.of(filePath));

        if (lines.size() <= 1) {
            return 0;
        }

        return lines.size() - 1;
    }
}