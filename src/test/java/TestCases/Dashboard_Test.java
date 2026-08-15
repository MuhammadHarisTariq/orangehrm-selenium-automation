package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.Base.BaseTest;
import orangehrm.Pages.Dashboard_Page;
import orangehrm.Pages.LoginPage;


public class Dashboard_Test extends BaseTest {


    // TC_06 Verify Dashboard is displayed after login
    @Test(groups = {"dashboard", "smoke", "regression"})
    public void Verify_Dashboard_display(){

        LoginPage mylogin = new LoginPage(driver);
        Dashboard_Page mydash = new Dashboard_Page(driver);


        mylogin.login("Admin","admin123");


        Assert.assertTrue(
            mydash.Dashboard_Display()
        );

    }



    // TC_07 Verify Admin menu navigation
    @Test(groups = {"dashboard", "regression"})
    public void Verify_adminmenu_navigation(){

        LoginPage mylogin = new LoginPage(driver);
        Dashboard_Page mydash = new Dashboard_Page(driver);


        mylogin.login("Admin","admin123");

        mydash.Click_Admin();


        Assert.assertTrue(
            driver.getCurrentUrl().contains("admin")
        );

    }



    // TC_08 Verify PIM menu navigation
    @Test(groups = {"dashboard", "regression"})
    public void Verify_Pimmenu_navigation(){

        LoginPage mylogin = new LoginPage(driver);
        Dashboard_Page mydash = new Dashboard_Page(driver);


        mylogin.login("Admin","admin123");

        mydash.Click_Pim();


        Assert.assertTrue(
            driver.getCurrentUrl().contains("pim")
        );

    }



    // TC_09 Verify Leave menu navigation
    @Test(groups = {"dashboard", "regression"})
    public void Verify_Leavemenu_navigation(){

        LoginPage mylogin = new LoginPage(driver);
        Dashboard_Page mydash = new Dashboard_Page(driver);


        mylogin.login("Admin","admin123");

        mydash.Click_Leave();


        Assert.assertTrue(
            driver.getCurrentUrl().contains("leave")
        );

    }



    // TC_10 Verify Logout functionality
    @Test(groups = {"dashboard", "smoke", "regression"})
    public void Verify_logout_Functionality(){

        LoginPage mylogin = new LoginPage(driver);
        Dashboard_Page mydash = new Dashboard_Page(driver);


        mylogin.login("Admin","admin123");

        mydash.logout();


        Assert.assertTrue(
            driver.getCurrentUrl().contains("login")
        );

    }

}