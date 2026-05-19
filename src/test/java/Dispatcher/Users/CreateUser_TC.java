package Dispatcher.Users;
import Dispatcher.Login.LogIn_Page;
import Dispatcher.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class CreateUser_TC extends TestBase_TC {
    LogIn_Page login;
    User_Page User;


    @BeforeTest
    public void SignIn () throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("CreditAgricole@cloudcom.io");
        login.EnterPassword("Admin@123");
        login.ClickRememberMe();
        login.ClickOnLoginButton();
        Thread.sleep(60000);
        User = new User_Page(driver);
        User.ClickOnUser();

    }

    @Test (priority = 1)
    public void VerifyForRequiredField() throws InterruptedException {
        User = new User_Page(driver);
        User.ClickOnAdd();
        User.ClickOnSubmit();
        driver.element().assertThat(User.ValidationForFirstName).exists().perform();
        driver.element().assertThat(User.ValidationForLastName).exists().perform();
        driver.element().assertThat(User.ValidationForEmail).exists().perform();
        driver.element().assertThat(User.ValidationForPhoneNumber).exists().perform();
        driver.element().assertThat(User.ValidationForRole).exists().perform();
        driver.element().assertThat(User.ValidationForCountry).exists().perform();
        driver.element().assertThat(User.ValidationForPassword).exists().perform();
    }
    @Test (priority = 3)
    public void VerifyThatCreationIsWorking() throws InterruptedException {
        User = new User_Page(driver);
        User.ClickOnAdd();
        User.TypeFirstName("ABC");User.TypeLastName("Test");User.TypeEmail("muhamed.gamal2017@gmail.com");
        User.TypePhoneNumber("01063783757");User.SelectRole("Testing Role");User.TypeJobTitle("Software Tester Engineer");
        User.SelectCountry("Egypt");User.TypePassword("Admin@123");User.SelectGender("Male");User.TypeAge("27");
        User.ClickOnActive();
        User.ClickOnSubmit();
        Thread.sleep(2000);

    }
    @Test (priority = 2)
    public void VerifyThatCancelIsWorking() throws InterruptedException {
        User = new User_Page(driver);
        User.TypeFirstName("ABC");User.TypeLastName("Test1");User.TypeEmail("muhamed.gamal2017@gmail.com");
        User.TypePhoneNumber("01063783757");User.SelectRole("Testing Role");User.TypeJobTitle("Software Tester Engineer");
        User.SelectCountry("Egypt");User.TypePassword("Admin@123");User.SelectGender("Male");User.TypeAge("27");
        User.ClickOnActive();
        User.ClickOnCancel();

    }


}