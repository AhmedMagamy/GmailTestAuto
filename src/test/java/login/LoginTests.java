package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utilites.ExcelUtility;


//this class has all tests related to login
public class LoginTests extends BaseTests {
    private LoginPage loginPage;
    private AccountPage accountPage;
    ExcelUtility excel = new ExcelUtility("TestData.xlsx");


    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

    }

    //in this method we do our tests
    @Test
    public void loginTcs() {
        //login with valid data
        loginPage.validLogin();
        //Assert you logged in by checking welcome message
        Assert.assertTrue(accountPage.checkWelcomeMessage());
        //Log out
        accountPage.doLogout();
        //Go to re-login
        loginPage.goToReLogin();
        //login with invalid data
        loginPage.inValidLogin();
        //Assert that login failed by checking error message
        Assert.assertTrue(loginPage.checkErrMsg());
    }






/*
// this is another type of execution using data provider to make our tests data driven and will give same result
    @Test(dataProvider = "logindata")
    public void loginTcsDataDriven(String email , String password ,String testCase){
        loginPage.login(email,password);
        switch(testCase)
        {
            case "valid" :
                Assert.assertTrue(accountPage.checkWelcomeMessage());
                //Log out
                accountPage.doLogout();
                //Go to re-login
                loginPage.goToReLogin();
                break;

            case "Invalid" :
                //Assert that login failed by checking error message
                Assert.assertTrue(loginPage.checkErrMsg());
                break;
        }
    }
*/


/*
//used to feed data driven tcs with login data
    @DataProvider
    public Object[][] logindata(){
        Object[][] logindata = new Object [2][3] ;
        excel.fillarrayfromeexcel(logindata, "LoginData");
        return logindata ;
    }
*/

}
