import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AppiumTest {
    AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        File app = new File(System.getProperty("user.dir") + '/', "sololearn.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println(app.getAbsolutePath());
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "GalaxyS7");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successLoginToBox() {

       // elementIsPresent(By.xpath("//android.widget.Button[@resource-id='com.sololearn:id/login_button']"));
        elementIsPresent(By.xpath("//*android.widget.Button[@resource-id='com.sololearn:id/login_button']"));
        driver.findElement(By.xpath("//*android.widget.Button[@resource-id='com.sololearn:id/login_button']")).click();
    }

    public boolean elementIsPresent(By by) {
        // Set Implicit Timeout to 0 not to check for a minute if the element is present
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        /*
        In this Try/catch we check for the required element
        Flow:
            1. We ask driver to find element with a sent parameter. If it finds it returns true
            2. If it catches the exception that no element is present, it handles it and returns false
            3. After all, it sets Implicit wait to a default value
         */
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

    }
}
