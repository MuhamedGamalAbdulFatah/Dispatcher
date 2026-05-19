package Dispatcher.DispatcherLB.Failovers;


import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class Failovers_Page {
    SHAFT.GUI.WebDriver driver;
    private final SoftAssert softAssert;
    public Failovers_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }
//Creation & Edition
    By BTN_Failovers = By.xpath("//div[@data-i18n=\"Failovers\"]");
    By BTN_CreateNew = By.xpath("//span[@class=\"d-sm-inline d-md-none d-lg-inline\"]");
    By BTN_Edit = By.xpath("(//a[@href=\"https://10.2.10.209:5050/Failover/93\"])[1]");
    By TXT_FailoverName = By.xpath("//input[@class=\"form-control rounded-pill p-2 px-3 ng-untouched " +
            "ng-pristine ng-invalid\"]");
    By LST_FailoverType = By.xpath("(//select[@formcontrolname=\"type\"])[1]");
    By CBOX_Failover1 = By.xpath("(//div[@class=\"p-0 m-0\"])[1]");
    By CBOX_Failover2 = By.xpath("(//div[@class=\"p-0 m-0\"])[2]");
    By CBOX_Failover3 = By.xpath("(//div[@class=\"p-0 m-0\"])[3]");
    By TXT_ErrorThreshold1 = By.xpath("(//input[@formcontrolname=\"errorThreshold\"])[1]");
    By TXT_ResponseTime1 = By.xpath("(//input[@formcontrolname=\"responseTime\"])[1]");
    By TXT_ResponseTimeOccurence1 = By.xpath("(//input[@formcontrolname=\"responseTimeOccurrence\"])[1]");
    By TXT_ErrorThreshold2 = By.xpath("(//input[@formcontrolname=\"errorThreshold\"])[2]");
    By TXT_ResponseTime2 = By.xpath("(//input[@formcontrolname=\"responseTime\"])[2]");
    By TXT_ResponseTimeOccurence2 = By.xpath("(//input[@formcontrolname=\"responseTimeOccurrence\"])[2]");
    By TXT_ErrorThreshold3 = By.xpath("(//input[@formcontrolname=\"errorThreshold\"])[3]");
    By TXT_ResponseTime3 = By.xpath("(//input[@formcontrolname=\"responseTime\"])[3]");
    By TXT_ResponseTimeOccurence3 = By.xpath("(//input[@formcontrolname=\"responseTimeOccurrence\"])[3]");

    By LST_FailoverDestination1 = By.xpath("(//select[@formcontrolname=\"failoverDestinationProvider\"])[1]");
    By LST_FailoverDestination2 = By.xpath("(//select[@formcontrolname=\"failoverDestinationProvider\"])[2]");
    By LST_FailoverDestination3 = By.xpath("(//select[@formcontrolname=\"failoverDestinationProvider\"])[3]");

    By BTN_Save = By.xpath("//button[@type=\"submit\"]");

    //Creation
    public Failovers_Page ClickOnFailovers()
    {
        driver.element().click(BTN_Failovers);
        return this;
    }
    public Failovers_Page ClickOnCreateNew()
    {
        driver.element().click(BTN_CreateNew);
        return this;
    }
    public Failovers_Page TypeOnFailoverName(String S)
    {
        driver.element().type(TXT_FailoverName , S );
        return this;
    }
    public Failovers_Page CheckOnFailover1()
    {
        driver.element().click(CBOX_Failover1);
        return this;
    }
    public Failovers_Page SelectType(String S) {
        driver.element().click(LST_FailoverType);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
By Etisalat1 = By.xpath("(//option[text()=' Etisalat '])[1]");
    By Etisalat2 = By.xpath("(//option[text()=' Etisalat '])[2]");
    By Vodafone1 = By.xpath("(//option[text()=' Vodafone '])[1]");
    By Vodafone2 = By.xpath("(//option[text()=' Vodafone '])[2]");
    By WE1 = By.xpath("(//option[text()=' WE '])[1]");
    By WE2 = By.xpath("(//option[text()=' WE '])[2]");

    public Failovers_Page CheckOnFailover2()
    {
        driver.element().click(CBOX_Failover2);
        return this;
    }
    public Failovers_Page CheckOnFailover3()
    {
        driver.element().click(CBOX_Failover3);
        return this;
    }

    public Failovers_Page TypeOnErrorThreshold1(String S)
    {
        driver.element().type(TXT_ErrorThreshold1 , S );
        return this;
    }
    public Failovers_Page TypeOnResponseTime1(String S)
    {
        driver.element().type(TXT_ResponseTime1 , S );
        return this;
    }
    public Failovers_Page TypeOnResponseTimeOccurence1(String S)
    {
        driver.element().type(TXT_ResponseTimeOccurence1 , S );
        return this;
    }
    public Failovers_Page TypeOnErrorThreshold2(String S)
    {
        driver.element().type(TXT_ErrorThreshold2 , S );
        return this;
    }
    public Failovers_Page TypeOnResponseTime2(String S)
    {
        driver.element().type(TXT_ResponseTime2 , S );
        return this;
    }
    public Failovers_Page TypeOnResponseTimeOccurence2(String S)
    {
        driver.element().type(TXT_ResponseTimeOccurence2 , S );
        return this;
    }
    public Failovers_Page TypeOnErrorThreshold3(String S)
    {
        driver.element().type(TXT_ErrorThreshold3 , S );
        return this;
    }
    public Failovers_Page TypeOnResponseTime3(String S)
    {
        driver.element().type(TXT_ResponseTime3 , S );
        return this;
    }
    public Failovers_Page TypeOnResponseTimeOccurence3(String S)
    {
        driver.element().type(TXT_ResponseTimeOccurence3 , S );
        return this;
    }
    public Failovers_Page SelectFailoverDestination1(String S) {
        driver.element().click(LST_FailoverDestination1);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
    public Failovers_Page SelectFailoverDestination2(String S) {
        driver.element().click(LST_FailoverDestination2);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
    public Failovers_Page SelectFailoverDestination3(String S) {
        driver.element().click(LST_FailoverDestination3);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }

    public Failovers_Page ClickOnSave()
    {
        driver.element().type(BTN_Save);
        return this;
    }
    //Edition
    public Failovers_Page ClickOnEdit()
    {
        driver.element().type(BTN_Edit);
        return this;
    }

    //Deleting
    By BTN_Delete = By.xpath("(//a[@class=\"icon delete ng-star-inserted\"])[1]");
    By BTN_YesDelete = By.xpath("//button[@class=\"swal2-confirm btn btn-danger-alert me-3 rounded-pill\"]");
    public Failovers_Page SetFirstDeleting() throws InterruptedException {
        driver.element().click(BTN_Delete);
        driver.element().click(BTN_YesDelete);
        Thread.sleep(2000);
        return this;
    }
}