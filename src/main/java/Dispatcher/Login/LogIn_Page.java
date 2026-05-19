package Dispatcher.Login;


import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.Scanner;

public class LogIn_Page {
    SHAFT.GUI.WebDriver driver;
    private final SoftAssert softAssert;
    public LogIn_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }

    final By TXT_UserName = By.xpath("//input[@id=\"email\"]");
    final By TXT_Password = By.xpath("//input[@id=\"password\"]");
    final By CBOX_RememberMe = By.xpath("//input[@type=\"checkbox\"]");
    final By BTN_Login = By.xpath("//button[@type=\"submit\"]");
    final By TXT_Warm = By.xpath("//span[@class=\"text-danger\"]");

    public LogIn_Page EnterUserName(String username)
    {
        driver.element().type(TXT_UserName,username);
        return this;
    }

    public LogIn_Page EnterPassword(String password) {
        driver.element().type(TXT_Password, password);
        return this;
    }
    public LogIn_Page ClickRememberMe() {
        driver.element().click(CBOX_RememberMe);
        return this;
    }

    public LogIn_Page ClickOnLoginButton() {
        driver.element().click(BTN_Login);
        return this;
    }
    public String Warming(){
       String Warm=driver.element().getText(TXT_Warm);
        return Warm;
    }
}