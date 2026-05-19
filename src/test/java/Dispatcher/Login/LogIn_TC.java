package Dispatcher.Login;
import freemarker.core.TemplateXHTMLOutputModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn_TC extends TestBase_TC {
    String URL = "https://10.2.10.209:880/RealTime-Analytics";

    LogIn_Page login;
    @Test (priority = 2)
    public void LogIn_WithValidNameAndPassword() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("CreditAgricole@cloudcom.io");
        login.EnterPassword("Admin@123");
        login.ClickOnLoginButton();
        Thread.sleep(3000);
        String ActualResult = driver.getDriver().getCurrentUrl();
        String ExpectedResult = URL ;
        Thread.sleep(5000);
        Assert.assertEquals(ActualResult, ExpectedResult, "User is logged in successfully");
        Thread.sleep(3000);
    }
    @Test (priority = 1)
    public void LogIn_WithInValidNameAndPassword() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("cloudcomai@gmail.com");
        login.EnterPassword("Test@20255");
        login.ClickRememberMe();
        login.ClickOnLoginButton();
        Thread.sleep(3000);
        String ExpectedResult = login.Warming();
        driver.element().assertThat(login.TXT_Warm).text().isEqualTo(ExpectedResult).perform();
        Thread.sleep(3000);
    }

}