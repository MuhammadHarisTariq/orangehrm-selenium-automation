package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.Base.BaseTest;
import orangehrm.Pages.LoginPage;
import DataProvider.LoginDataProvider;

public class Login_Test extends BaseTest {

    // TC_01 Verify login page opens

    @Test
    public void Verify_login() {
        LoginPage login = new LoginPage(driver);

        Assert.assertTrue(login.isLoginPageDisplayed());

    }

    // TC_02 Login with valid credentials
    // TC_03 Login with invalid username
    // TC_04 Login with invalid password

    @Test(dataProvider = "LoginData", dataProviderClass = LoginDataProvider.class)
    public void LoginTest(String username, String password) {

        LoginPage login = new LoginPage(driver);

        
        login.isLoginPageDisplayed();

        login.enterUsername(username);

        login.enterPassword(password);

        login.clickLogin();

    }

    // TC_05 Forgot Password link works

    @Test(groups = {"login", "regression"})
    public void Verify_forgetPassword_link() {

        LoginPage login = new LoginPage(driver);

        login.isLoginPageDisplayed();

        login.clickForgotPassword();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("requestPasswordResetCode"));
    }

}