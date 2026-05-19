package Dispatcher.Login;
import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase_TC {

    protected SHAFT.GUI.WebDriver driver ;

    @BeforeTest
    public void setupBrowse() throws InterruptedException {
        driver = new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME);
        driver.browser().maximizeWindow();
        driver.browser().navigateToURL("https://10.2.20.30");
        Thread.sleep(5000);
    }
//10.209:5050
    @AfterTest
    public void Quit() {
        driver.quit();
    }
}
