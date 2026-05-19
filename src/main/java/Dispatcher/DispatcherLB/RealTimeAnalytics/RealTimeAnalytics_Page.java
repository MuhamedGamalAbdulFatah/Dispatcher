package Dispatcher.DispatcherLB.RealTimeAnalytics;

import Dispatcher.DispatcherLB.SMSTrafficDistribution.SMSTraffic_Page;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class RealTimeAnalytics_Page {
    SHAFT.GUI.WebDriver driver;
    private final SoftAssert softAssert;
    public RealTimeAnalytics_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }
    By BTN_RealTimeAnalytics = By.xpath("//div[@data-i18n=\"RealTimeAnalytics\"]");

    By TXT_FromDate = By.xpath("(//input[@type=\"datetime-local\"])[1]");
    By TXT_ToDate = By.xpath("(//input[@type=\"datetime-local\"])[2]");

    By DateError = By.xpath("//span[@id=\"dateError\"]");

    By BTN_Submit = By.xpath("//button[@type=\"submit\"]");

    private final By successRate  = By.id("successRate");
    private final By failureRate  = By.id("failureRate");

    public RealTimeAnalytics_Page ClickOnRealTimeAnalytics() {
        driver.element().click(BTN_RealTimeAnalytics);
        return this;
    }

    public RealTimeAnalytics_Page TypeOnFromDate(String s) {
        driver.element().type(TXT_FromDate, s);
        return this;
    }

    public RealTimeAnalytics_Page TypeOnToDate(String s) {
        driver.element().type(TXT_ToDate, s);
        return this;
    }

    public RealTimeAnalytics_Page ClickOnSubmit() {
        driver.element().click(BTN_Submit);
        return this;
    }

    public double getSuccessRate() {
        return readPercent(successRate);
    }

    public double getFailureRate() {
        return readPercent(failureRate);
    }

    private double readPercent(By locator) {
        String raw = driver.element().getText(locator);
        String clean = raw.replace("%", "").trim();
        return Double.parseDouble(clean);
    }
}