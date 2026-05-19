package Dispatcher.DispatcherLB.DispatcherLBList;


import Dispatcher.Users.User_Page;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;


public class DispatcherLBList_Page {
    SHAFT.GUI.WebDriver driver;
    private final SoftAssert softAssert;
    public DispatcherLBList_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }
//Creation & Edition
    By BTN_DispatcherLBList = By.xpath("//div[@data-i18n=\"Dispatcher LB List\"]");
    By BTN_CreateNew = By.xpath("//span[@class=\"d-sm-inline d-md-none d-lg-inline\"]");
    By BTN_Edit = By.xpath("(//a[@class=\"icon edit ng-star-inserted\"])[1]");
    By TXT_DispatcherLBName = By.xpath("(//input[@type=\"text\"])[1]");
    By LST_DisptcherType = By.xpath("//select[@formcontrolname=\"lbType\"]");
    By CBOX_Vodafone = By.xpath("(//div[@class=\"col-1\"])[1]");
    By CBOX_Etisalat = By.xpath("(//div[@class=\"col-1\"])[2]");
    By CBOX_We = By.xpath("(//div[@class=\"col-1\"])[3]");
    By TXT_VodafonePercentage = By.xpath("(//input[@type=\"number\"])[2]");
    By TXT_EtisalatPercentage = By.xpath("(//input[@type=\"number\"])[3]");
    By TXT_WePercentage = By.xpath("(//input[@type=\"number\"])[4]");
    By BTN_Save = By.xpath("//button[@type=\"submit\"]");

    //Creation
    public DispatcherLBList_Page ClickOnDispatcherLBList()
    {
        driver.element().click(BTN_DispatcherLBList);
        return this;
    }
    public DispatcherLBList_Page ClickOnCreateNew()
    {
        driver.element().click(BTN_CreateNew);
        return this;
    }
    public DispatcherLBList_Page TypeOnDispatcherName(String S)
    {
        driver.element().type(TXT_DispatcherLBName , S );
        return this;
    }
    public DispatcherLBList_Page CheckOnVodafone()
    {
        driver.element().click(CBOX_Vodafone);
        return this;
    }
    public DispatcherLBList_Page SelectType(String S) {
        driver.element().click(LST_DisptcherType);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
    public DispatcherLBList_Page CheckOnEtisalat()
    {
        driver.element().click(CBOX_Etisalat);
        return this;
    }
    public DispatcherLBList_Page CheckOnWe()
    {
        driver.element().click(CBOX_We);
        return this;
    }

    public DispatcherLBList_Page TypeOnVodafonePercentage(String S)
    {
        driver.element().type(TXT_VodafonePercentage , S );
        return this;
    }
    public DispatcherLBList_Page TypeOnEtisalatPercentage(String S)
    {
        driver.element().type(TXT_EtisalatPercentage , S );
        return this;
    }
    public DispatcherLBList_Page TypeOnWePercentage(String S)
    {
        driver.element().type(TXT_WePercentage , S );
        return this;
    }
    public DispatcherLBList_Page ClickOnSave()
    {
        driver.element().type(BTN_Save);
        return this;
    }
    //Edition
    public DispatcherLBList_Page ClickOnEdit()
    {
        driver.element().type(BTN_Edit);
        return this;
    }
//Resetting
    By BTN_Reset = By.xpath("(//a[@class=\"icon edit ng-star-inserted\"])[2]");
    By BTN_YesReset = By.xpath("//button[@class=\"swal2-confirm btn btn-danger-alert me-3 rounded-pill\"]");

    public DispatcherLBList_Page SetFirstResetting() throws InterruptedException {
        driver.element().click(BTN_Reset);
        driver.element().click(BTN_YesReset);
        Thread.sleep(2000);
        return this;
    }
    //Deleting
    By BTN_Delete = By.xpath("(//a[@class=\"icon delete ng-star-inserted\"])[1]");
    By BTN_YesDelete = By.xpath("//button[@class=\"swal2-confirm btn btn-danger-alert me-3 rounded-pill\"]");
    public DispatcherLBList_Page SetFirstDeleting() throws InterruptedException {
        driver.element().click(BTN_Delete);
        driver.element().click(BTN_YesDelete);
        Thread.sleep(2000);
        return this;
    }
}