package Dispatcher.Users;


import com.epam.ta.reportportal.ws.model.StartRQ;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class User_Page {
    SHAFT.GUI.WebDriver driver;
    private final SoftAssert softAssert;
    public User_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }

    final public By BTN_User = By.xpath("//a[@href=\"/subaccounts\"]");
    public User_Page ClickOnUser()
    {
        driver.element().click(BTN_User);
        return this;
    }

    //Creation & Edition
    By BTN_Add = By.xpath("//span[@class=\"d-none d-lg-inline-block\"]");
    By BTN_Edition = By.xpath("(//i[@class=\"bx bx-edit\"])[1]");
    By TXT_FirstName = By.xpath("//input[@id=\"add-first-name\"]");
    By TXT_LastName = By.xpath("//input[@id=\"add-last-name\"]");
    By TXT_Email = By.xpath("//input[@id=\"add-email\"]");
    By TXT_PhoneNumber = By.xpath("//input[@id=\"add-phone-no\"]");
    By LST_Role = By.id("add-role");
    By TXT_JobTitle = By.id("add-job-title");
    By LST_Country = By.xpath("//Select[@id=\"add-country\"]");
    By TXT_Password = By.xpath("//input[@id=\"add-password\"]");
    By LST_Gender = By.xpath("//Select[@id=\"add-gender\"]");
    By TXT_Age = By.xpath("//input[@id=\"add-age\"]");
    By CBOX_Active = By.xpath("//input[@id=\"add-status\"]");
    By BTN_Submit = By.xpath("//button[@type=\"submit\"]");
    By BTN_Cancel = By.xpath("//button[@type=\"reset\"]");
    By ValidationForFirstName = By.xpath("(//div[@data-validator=\"notEmpty\"])[1]");
    By ValidationForLastName = By.xpath("(//div[@data-validator=\"notEmpty\"])[2]");
    By ValidationForEmail = By.xpath("(//div[@data-validator=\"notEmpty\"])[3]");
    By ValidationForPhoneNumber = By.xpath("(//div[@data-validator=\"notEmpty\"])[4]");
    By ValidationForRole = By.xpath("(//div[@data-validator=\"notEmpty\"])[5]");
    By ValidationForCountry = By.xpath("(//div[@data-validator=\"notEmpty\"])[6]");
    By ValidationForPassword = By.xpath("(//div[@data-validator=\"notEmpty\"])[7]");


    public User_Page ClickOnAdd() {
        driver.element().click(BTN_Add);
        return this;
    }
    public User_Page ClickOnEdit() {
        driver.element().click(BTN_Edition);
        return this;
    }
    public User_Page TypeFirstName(String S) {
        driver.element().type(TXT_FirstName,S);
        return this;
    }

    public User_Page TypeLastName(String S) {
        driver.element().type(TXT_LastName,S);
        return this;
    }
    public User_Page TypeEmail(String S) {
        driver.element().type(TXT_Email,S);
        return this;
    }
    public User_Page TypePhoneNumber(String S) {
        driver.element().type(TXT_PhoneNumber,S);
        return this;
    }
    public User_Page SelectRole(String S) {
        driver.element().click(LST_Role);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
    public User_Page TypeJobTitle(String S) {
        driver.element().type(TXT_JobTitle,S);
        return this;
    }
    public User_Page SelectCountry(String S) {
        driver.element().click(LST_Country);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
    public User_Page TypePassword(String S) {
        driver.element().type(TXT_Password,S);
        return this;
    }
    public User_Page SelectGender(String S) {
        driver.element().click(LST_Gender);
        By option = By.xpath(String.format("//option[text()='%s']", S));
        driver.element().click(option);
        return this;
    }
    public User_Page TypeAge(String S) {
        driver.element().type(TXT_Age,S);
        return this;
    }
    public User_Page ClickOnActive() {
        driver.element().click(CBOX_Active);
        return this;
    }
    public User_Page ClickOnSubmit() {
        driver.element().click(BTN_Submit);
        return this;
    }
    public User_Page ClickOnCancel() {
        driver.element().click(BTN_Cancel);
        return this;
    }
    // Export
    By BTN_Export = By.xpath("//button[@class=\"btn btn-secondary buttons-collection dropdown-toggle btn-" +
            "outline-primary ms-3\"]");
    By BTN_CSV = By.xpath("//a[@class=\"dt-button dropdown-item buttons-csv buttons-html5\"]");





}