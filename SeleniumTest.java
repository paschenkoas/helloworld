import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;

    @Before
    public void beforeMethod() {
        driver = new ChromeDriver();
    }

    @Test
    public void mainTest() {
        driver.get("https://google.com");
        driver.findElement(By.cssSelector("input#lst-ib")).click();
        driver.findElement(By.cssSelector("input#lst-ib")).sendKeys("cats");
        driver.findElement(By.cssSelector("input#lst-ib")).sendKeys(Keys.ENTER);
    }

    @After
    public void finish(){
        driver.quit();
    }
}