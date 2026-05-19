package Dispatcher.DispatcherLB.DetailedSMSTraffic;

import Dispatcher.DispatcherLB.SMSTrafficDistribution.SMSTraffic_Page;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class DetailedSMSTraffic_Page {
    SHAFT.GUI.WebDriver driver;
    private final SoftAssert softAssert;
    public DetailedSMSTraffic_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }
    By BTN_DetailedSMSTraffic = By.xpath("//div[@data-i18n=\"SMSTrafficDistribution\"]");

    By TXT_FromDate = By.xpath("(//input[@type=\"datetime-local\"])[1]");
    By TXT_ToDate = By.xpath("(//input[@type=\"datetime-local\"])[2]");

    By DateError = By.xpath("//span[@id=\"dateError\"]");

    By BTN_Submit = By.xpath("//button[@type=\"submit\"]");
    By BTN_Export = By.id("exportBtn");
    By BTN_Action = By.xpath("(//button[@class=\"btn btn-sm btn-outline-primary\"])[1]");
    By Table = By.xpath("//div[@class=\"modal-content\"]");

    public DetailedSMSTraffic_Page ClickOnDetailedSMSTraffic() {
        driver.element().click(BTN_DetailedSMSTraffic);
        return this;
    }

    public DetailedSMSTraffic_Page TypeOnFromDate(String s) {
        driver.element().type(TXT_FromDate, s);
        return this;
    }

    public DetailedSMSTraffic_Page TypeOnToDate(String s) {
        driver.element().type(TXT_ToDate, s);
        return this;
    }

    public DetailedSMSTraffic_Page ClickOnSubmit() {
        driver.element().click(BTN_Submit);
        return this;
    }
    public DetailedSMSTraffic_Page ClickOnAction() {
        driver.element().click(BTN_Action);
        return this;
    }

    public DetailedSMSTraffic_Page ClickOnExport()
    {
        driver.element().click(BTN_Export);
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