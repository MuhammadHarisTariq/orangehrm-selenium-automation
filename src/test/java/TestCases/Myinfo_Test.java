package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.MyInfoDataProvider;
import orangehrm.Base.BaseTest;
import orangehrm.Pages.Dashboard_Page;
import orangehrm.Pages.LoginPage;
import orangehrm.Pages.MyInfo_Page;

public class Myinfo_Test extends BaseTest {

    // TC_20 Update personal details
    @Test(dataProvider = "PersonalDetailsData", dataProviderClass = MyInfoDataProvider.class)
    public void UpdatePersonalDetails(
            String firstName,
            String middleName,
            String lastName) {

        try {

            LoginPage login = new LoginPage(driver);
            Dashboard_Page dashboard = new Dashboard_Page(driver);
            MyInfo_Page myInfo = new MyInfo_Page(driver);

            login.login("Admin", "admin123");

            dashboard.Click_Myinfo();

            myInfo.enterFirstName(firstName);
            myInfo.enterMiddleName(middleName);
            myInfo.enterLastName(lastName);

            myInfo.clickSave();

            Assert.assertTrue(
                    myInfo.getSuccessToastMessage().contains("Successfully Updated"),
                    "Personal details were not updated successfully");

        } catch (AssertionError e) {

            Assert.fail(
                    "Personal details assertion failed: "
                            + e.getMessage());

        } catch (Exception e) {

            Assert.fail(
                    "Personal details test failed due to automation error: "
                            + e.getMessage());
        }
    }
}