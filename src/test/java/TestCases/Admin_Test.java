package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.TimeoutException;

import DataProvider.AdminDataProvider;
import orangehrm.Base.BaseTest;
import orangehrm.Pages.Admin_Page;
import orangehrm.Pages.Dashboard_Page;
import orangehrm.Pages.LoginPage;

public class Admin_Test extends BaseTest {

    // TC_11 Search user by Username
    @Test(dataProvider = "UserNameData", dataProviderClass = AdminDataProvider.class)
    public void Verify_Search_By_UserName(String username) {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dash = new Dashboard_Page(driver);
        Admin_Page admin = new Admin_Page(driver);

        login.login("Admin", "admin123");
        dash.Click_Admin();

        admin.searchByUsername(username);
        admin.clickSearch();

        try {

            String actualUsername = admin.getFirstResultUsername();

            Assert.assertEquals(
                    actualUsername,
                    username,
                    "Search result username does not match");

        } catch (TimeoutException e) {

            Assert.fail(
                    "Expected username '" + username + "' was not found in search results.",
                    e);
        }
    }

    // TC_12 Search user by User Role
    @Test(dataProvider = "UserRoleData", dataProviderClass = AdminDataProvider.class)
    public void Verify_Search_By_UserRole(String role) {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dash = new Dashboard_Page(driver);
        Admin_Page admin = new Admin_Page(driver);

        login.login("Admin", "admin123");
        dash.Click_Admin();

        admin.selectSearchUserRole(role);
        admin.clickSearch();

        admin.scrollDown();

        Assert.assertEquals(admin.getResultUserRole(), role);
    }

    // TC_13 Search user by Employee Name
    @Test(dataProvider = "EmployeeNameData", dataProviderClass = AdminDataProvider.class)
    public void Verify_Search_By_EmployeeName(String employeeName) {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dash = new Dashboard_Page(driver);
        Admin_Page admin = new Admin_Page(driver);

        login.login("Admin", "admin123");
        dash.Click_Admin();

        admin.searchByEmployeeName(employeeName);
        admin.clickSearch();

        admin.scrollDown();

        Assert.assertEquals(admin.getResultEmployeeName(), employeeName);
    }

    // TC_14 Search user by Status
    @Test(dataProvider = "StatusData", dataProviderClass = AdminDataProvider.class)
    public void Verify_Search_By_Status(String status) {

        try {

            LoginPage login = new LoginPage(driver);
            Dashboard_Page dash = new Dashboard_Page(driver);
            Admin_Page admin = new Admin_Page(driver);

            login.login("Admin", "admin123");
            dash.Click_Admin();

            admin.selectSearchStatus(status);
            admin.clickSearch();

            admin.scrollDown();

            Assert.assertEquals(admin.getResultStatus(), status);

        } catch (AssertionError e) {

            Assert.fail("Status search assertion failed: " + e.getMessage());

        } catch (Exception e) {

            Assert.fail("Status search failed due to Selenium/automation error: "
                    + e.getMessage());

        }
    }

    // TC_15 Reset Search Filters
    @Test(groups = { "admin", "smoke", "regression" })
    public void Verify_Reset_Search_Filter() {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dash = new Dashboard_Page(driver);
        Admin_Page admin = new Admin_Page(driver);

        login.login("Admin", "admin123");
        dash.Click_Admin();

        admin.searchByUsername("Haris");
        ;

        admin.clickReset();

        Assert.assertEquals(admin.getResetvalueofusername(), "");
    }

}