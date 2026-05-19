package Dispatcher.DispatcherLB.Failovers;
import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditFailovers_TC extends TestBase_TC {
    private static final Logger log = LoggerFactory.getLogger(EditFailovers_TC.class);
    LogIn_Page login;
    Failovers_Page Failovers;
    @BeforeTest
    public void SignIn () throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("CreditAgricole@cloudcom.io");
        login.EnterPassword("Admin@123");
        login.ClickRememberMe();
        login.ClickOnLoginButton();
        Thread.sleep(20000);
        Failovers = new Failovers_Page(driver);
        Failovers.ClickOnFailovers();

    }
    @Test(priority = 1)
    public void TC_01_EditFailoverWithValidSingleRuleShouldBeUpdatedSuccessfully() throws InterruptedException {
        Failovers = new Failovers_Page(driver);

        Failovers
                .ClickOnCreateNew()
                .TypeOnFailoverName("Automation Edit Failover Single Rule")
                .SelectType(" All ")
                .CheckOnFailover1()
                .TypeOnErrorThreshold1("2")
                .TypeOnResponseTime1("2")
                .TypeOnResponseTimeOccurence1("2");
        driver.element().click(Failovers.Etisalat1);

        driver.element().assertThat(Failovers.BTN_Save)
                .isVisible()
                .perform();

        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void TC_02_EditFailoverWithMultipleRulesShouldBeUpdatedSuccessfully() throws InterruptedException {
        Failovers = new Failovers_Page(driver);

        Failovers
                .CheckOnFailover2()
                .CheckOnFailover3()
                .TypeOnErrorThreshold1("1")
                .TypeOnResponseTime1("1")
                .TypeOnResponseTimeOccurence1("1");
        driver.element().click(Failovers.Etisalat1);
               Failovers .TypeOnErrorThreshold2("2")
                .TypeOnResponseTime2("2")
                .TypeOnResponseTimeOccurence2("2");
        driver.element().click(Failovers.WE2);
        Failovers
                .TypeOnErrorThreshold3("3")
                .TypeOnResponseTime3("3")
                .TypeOnResponseTimeOccurence3("3");
        driver.element().click(Failovers.Vodafone2);

        driver.element().assertThat(Failovers.BTN_Save)
                .isVisible()
                .perform();

        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void TC_03_EditFailoverWithNegativeValuesShouldShowValidationError() {
        Failovers = new Failovers_Page(driver);

        Failovers
                .CheckOnFailover2()
                .CheckOnFailover3()
                .TypeOnErrorThreshold1("-1")
                .TypeOnResponseTime1("-1")
                .TypeOnResponseTimeOccurence1("-1");
        driver.element().click(Failovers.Etisalat1);

        driver.element().assertThat(Failovers.BTN_Save)
                .isDisabled()
                .perform();
    }

    @Test(priority = 4)
    public void TC_04_EditFailoverWithZeroValuesShouldShowValidationError() {
        Failovers = new Failovers_Page(driver);

        Failovers
                .TypeOnErrorThreshold1("0")
                .TypeOnResponseTime1("0")
                .TypeOnResponseTimeOccurence1("0");
        driver.element().click(Failovers.Etisalat1);

        driver.element().assertThat(Failovers.BTN_Save)
                .isDisabled()
                .perform();
    }

    @Test(priority = 5)
    public void TC_05_EditFailoverWithEmptyRequiredFieldsShouldShowValidationError() {
        Failovers = new Failovers_Page(driver);

        Failovers
                .TypeOnErrorThreshold1("")
                .TypeOnResponseTime1("")
                .TypeOnResponseTimeOccurence1("");
        driver.element().click(Failovers.Etisalat1);

        driver.element().assertThat(Failovers.BTN_Save)
                .isDisabled()
                .perform();
    }
}