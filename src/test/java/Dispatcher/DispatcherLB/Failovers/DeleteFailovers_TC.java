package Dispatcher.DispatcherLB.Failovers;
import Dispatcher.DispatcherLB.DispatcherLBList.DispatcherLBList_Page;
import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteFailovers_TC extends TestBase_TC {
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
    public void TC_01_DeletedSuccessfully() throws InterruptedException {
        Failovers = new Failovers_Page(driver);

        Failovers
                .SetFirstDeleting();
        Thread.sleep(1000);

    }




}