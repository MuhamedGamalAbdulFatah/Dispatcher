package Dispatcher.DispatcherLB.DispatcherLBList;
import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditDispatcherLBList_TC extends TestBase_TC {
    LogIn_Page login;
    DispatcherLBList_Page Dispatcher;


    @BeforeTest
    public void SignIn () throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("CreditAgricole@cloudcom.io");
        login.EnterPassword("Admin@123");
        login.ClickRememberMe();
        login.ClickOnLoginButton();
        Thread.sleep(60000);
        Dispatcher = new DispatcherLBList_Page(driver);
        Dispatcher.ClickOnDispatcherLBList();

    }

    @Test
    public void TC_01_EditDispatcherLB_WithVodafone100Percent_ShouldBeEditedSuccessfully() throws InterruptedException {
        Dispatcher = new DispatcherLBList_Page(driver);

        Dispatcher
                .ClickOnEdit()
                .TypeOnDispatcherName("Automation LB Vodafone 100")
                .SelectType(" Percentege-Base ")
                .CheckOnEtisalat()
                .CheckOnWe();
        driver.element().clear(Dispatcher.TXT_VodafonePercentage);
        Dispatcher
                .TypeOnVodafonePercentage("100");
        driver.element().assertThat(Dispatcher.BTN_Save)
                .isVisible()
                .perform();
        Thread.sleep(1000);

    }

    @Test
    public void TC_02_EditDispatcherLB_WithTotal100PercentForAllProviders_ShouldBeEditedSuccessfully() throws InterruptedException {
        Dispatcher = new DispatcherLBList_Page(driver);

        Dispatcher
                .TypeOnDispatcherName("Automation LB Total 100")
                .SelectType(" Percentege-Base ")
                .CheckOnEtisalat()
                .CheckOnWe()
                .TypeOnVodafonePercentage("40")
                .TypeOnEtisalatPercentage("30")
                .TypeOnWePercentage("30");
        driver.element().assertThat(Dispatcher.BTN_Save)
                .isVisible()
                .perform();



    }

    @Test
    public void TC_03_EditDispatcherLB_WithNegativePercentages_ShouldShowValidationError() {
        Dispatcher = new DispatcherLBList_Page(driver);

        Dispatcher

                .TypeOnDispatcherName("Automation LB Negative")
                .SelectType(" Percentege-Base ")
                .TypeOnVodafonePercentage("-10")
                .TypeOnEtisalatPercentage("-20")
                .TypeOnWePercentage("-30");
        driver.element().assertThat(Dispatcher.BTN_Save)
                .isDisabled()
                .perform();
    }

    @Test
    public void TC_04_EditDispatcherLB_WithTotalMoreThan100Percent_ShouldShowValidationError() {
        Dispatcher = new DispatcherLBList_Page(driver);

        Dispatcher
                .TypeOnDispatcherName("Automation LB More Than 100")
                .SelectType(" Percentege-Base ")
                .TypeOnVodafonePercentage("50")
                .TypeOnEtisalatPercentage("40")
                .TypeOnWePercentage("30");
        driver.element().assertThat(Dispatcher.BTN_Save)
                .isDisabled()
                .perform();


    }

    @Test
    public void TC_05_EditDispatcherLB_WithTotalLessThan100AndGreaterThan0_ShouldShowValidationError() {
        Dispatcher = new DispatcherLBList_Page(driver);
        Dispatcher
                .TypeOnDispatcherName("Automation LB Less Than 100")
                .SelectType(" Percentege-Base ")

                .TypeOnVodafonePercentage("20")
                .TypeOnEtisalatPercentage("20")
                .TypeOnWePercentage("20");
        driver.element().assertThat(Dispatcher.BTN_Save)
                .isDisabled()
                .perform();

    }


}