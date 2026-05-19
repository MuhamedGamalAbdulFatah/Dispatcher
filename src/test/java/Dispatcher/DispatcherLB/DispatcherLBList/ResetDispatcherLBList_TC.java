package Dispatcher.DispatcherLB.DispatcherLBList;
import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ResetDispatcherLBList_TC extends TestBase_TC {
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
    public void TC_01_ResetSuccessfully() throws InterruptedException {
        Dispatcher = new DispatcherLBList_Page(driver);

        Dispatcher
                .SetFirstResetting();
        Thread.sleep(1000);

    }




}