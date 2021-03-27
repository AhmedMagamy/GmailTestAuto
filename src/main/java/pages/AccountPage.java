package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//In this class we create all web elements and do all actions related to Account page so we can call and reuse them easily.
public class AccountPage {
    private WebDriver driver;
    private By welcomeMessage = By.xpath("//h1");
    private By logOutBtn = By.id("gb_71");
    private By logOutIcon = By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div/div/a");


    public AccountPage(WebDriver browser) {
        this.driver = browser;
    }


    //method that verify that we are successfully logged-in and we are in account main page by checking and reading welcome message
    public Boolean checkWelcomeMessage() {
        System.out.println("the welc msg =" + driver.findElement(welcomeMessage).getText());
        if (driver.findElement(welcomeMessage).isDisplayed()) {
            return true;
        }
        return false;
    }

    //method to do logout
    public void doLogout() {
        driver.findElement(logOutIcon).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(logOutBtn)));
        driver.findElement(logOutBtn).click();

    }

}
