package Dispatcher.DispatcherLB.Failovers;
import Dispatcher.DispatcherLB.DispatcherLBList.DispatcherLBList_Page;
import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateFailovers_TC extends TestBase_TC {
    private static final Logger log = LoggerFactory.getLogger(CreateFailovers_TC.class);
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

    @Test
    public void TC_01_CreateFailoversShouldBeCreatedSuccessfully() throws InterruptedException {
        Failovers = new Failovers_Page(driver);

        Failovers
                .ClickOnCreateNew()
                .TypeOnFailoverName("Automation Failover Vodafone")
                .SelectType(" All ")
                .CheckOnFailover1()
                .TypeOnErrorThreshold1("1")
                .TypeOnResponseTime1("1")
                .TypeOnResponseTimeOccurence1("1");
                driver.element().click(Failovers.Etisalat1);

        driver.element().assertThat(Failovers.BTN_Save)
                .isVisible()
                .perform();
        Thread.sleep(1000);

    }

    @Test
    public void TC_02_CreateFailoversShouldBeCreatedSuccessfully() throws InterruptedException {
        Failovers = new Failovers_Page(driver);

        Failovers

                .CheckOnFailover2()
                .CheckOnFailover3()
                .TypeOnErrorThreshold2("1")
                .TypeOnResponseTime2("1")
                .TypeOnResponseTimeOccurence2("1");
        driver.element().click(Failovers.WE2);
                Failovers
                .TypeOnErrorThreshold3("1")
                .TypeOnResponseTime3("1")
                .TypeOnResponseTimeOccurence3("1");
        driver.element().click(Failovers.Etisalat2);



        driver.element().assertThat(Failovers.BTN_Save)
                .isVisible()
                .perform();
        Thread.sleep(1000);


    }

    @Test
    public void TC_03_CreateFailoversShouldBeCreatedValidationError() {
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




}