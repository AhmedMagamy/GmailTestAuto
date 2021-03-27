package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.ExcelUtility;


//In this class we create all web elements and do all actions related to login page so we can call and reuse them easily.
public class LoginPage {
    private WebDriver driver;
    ExcelUtility excel = new ExcelUtility("TestData.xlsx");

    private By emailField = By.id("identifierId");
    private By nextButton = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]");
    private By passwordField = By.name("password");
    private By useAnotherAcc = By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[2]");
    private By errMsg = By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]");


    // Any class need to use login page must pass his driver to it
    public LoginPage(WebDriver browser) {
        this.driver = browser;
    }

    //Enter email data to email field
    public void setEmail(String email) {
        WebElement emailElem = driver.findElement(emailField);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emailElem));
        emailElem.click();
        emailElem.sendKeys(email);
    }

    //Enter password  data to password field
    public void setPassword(String password) {

        WebElement passFieldElem = driver.findElement(passwordField);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(passFieldElem));
        passFieldElem.click();
        passFieldElem.sendKeys(password);
    }

    //method to click on next button
    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    //method to do login so at eny time we can call it and pass login data to do login
    public void login(String email, String password) {
        setEmail(email);
        clickNext();
        setPassword(password);
        clickNext();
    }

    //method that read valid login data from external excel file and call login method to do valid login
    public void validLogin() {
        String email = excel.getCellDataString("LoginData", 0, 0);
        String password = excel.getCellDataString("LoginData", 0, 1);
        login(email, password);
    }

    //method that read invalid  login data from external excel file and call login method to do invalid login
    public void inValidLogin() {
        String email = excel.getCellDataString("LoginData", 1, 0);
        String password = excel.getCellDataString("LoginData", 1, 1);
        login(email, password);

    }

    //click on "open another account" to go to re-login
    public void goToReLogin() {
        WebElement useAnotherAcountElem = driver.findElement(useAnotherAcc);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(useAnotherAcountElem));
        useAnotherAcountElem.click();
    }

    //method that verify that we are failed to  login by checking and reading err message
    public Boolean checkErrMsg() {
        WebElement errMsgElem = driver.findElement(errMsg);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(errMsgElem));
        System.out.println("the err msg = " + driver.findElement(errMsg).getText());
        if (errMsgElem.isDisplayed()) {
            return true;
        }
        return false;

    }


}
