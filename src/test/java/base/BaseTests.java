package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//This class has all setup and closing actions that any test class will need
public class BaseTests {
    public WebDriver driver;

    //setup method that calls the browser driver and open base url
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/signin");
        driver.manage().window().maximize();

    }

    //responsible for closing
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        //driver.quit();
    }
}
