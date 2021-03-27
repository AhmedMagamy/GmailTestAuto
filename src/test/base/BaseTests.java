package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class BaseTests {
    public WebDriver driver ;


    @BeforeClass
    public void setUp(){
      //  System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);


    }


    @AfterClass
    public void tearDown(){
   //   driver.quit();
    }




}
