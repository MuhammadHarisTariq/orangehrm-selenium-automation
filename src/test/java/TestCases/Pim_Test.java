package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.PIMDataProvider;
import orangehrm.Base.BaseTest;
import orangehrm.Pages.Dashboard_Page;
import orangehrm.Pages.LoginPage;
import orangehrm.Pages.PIM_Page;

public class Pim_Test extends BaseTest {

    String generatedEmployeeId;

    // TC_22 Add new employee

    @Test(priority = 1,dataProvider = "AddEmployeeDataProvider", dataProviderClass = PIMDataProvider.class)
    public void Verify_Add_Employee(String firstName,
            String middleName,
            String lastName) {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        PIM_Page pim = new PIM_Page(driver);

        login.login("Admin", "admin123");

        dashboard.Click_PIM();

        pim.Navigate_ToAddEmployee();

        generatedEmployeeId = pim.getGeneratedEmployeeId();

        pim.Add_FirstName(firstName);
        pim.Add_MiddleName(middleName);
        pim.Add_LastName(lastName);

        pim.Click_Emp_SaveButton();

        Assert.assertTrue(
                pim.isEmployeeAdded(),
                "Employee was not added successfully.");
    }

    // TC_18 Search employee by name

    @Test(priority = 2,dataProvider = "SearchEmployeeNameData", dataProviderClass = PIMDataProvider.class)
    public void Search_EmployeeByName(String employeeName) {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        PIM_Page pim = new PIM_Page(driver);

        login.login("Admin", "admin123");

        dashboard.Click_PIM();

        pim.Click_EmployeeName(employeeName);
        pim.Click_SearchButton();
        pim.scrollDown();

        Assert.assertEquals(
                pim.Result_EmpFirstMiddleName(),
                employeeName);
    }

    // TC_19 Search employee by ID

     @Test(priority = 3,dependsOnMethods = "Verify_Add_Employee")
    public void Search_EmployeeByID() {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        PIM_Page pim = new PIM_Page(driver);

        login.login("Admin", "admin123");

        dashboard.Click_PIM();

        pim.Click_EmployeeID(generatedEmployeeId);;
        pim.Click_SearchButton();
        pim.scrollDown();

        Assert.assertEquals(
                pim.Result_EmpId(),
                generatedEmployeeId);
    }


    // TC_19 Reset employee search

    @Test(priority = 4)
    public void Reset_EmployeeSearch() {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        PIM_Page pim = new PIM_Page(driver);

        login.login("Admin", "admin123");

        dashboard.Click_PIM();

        pim.Click_EmployeeName("Muhammad Haris");

        pim.clickReset();

        Assert.assertEquals(pim.getEmployeeNameValue(),"");
    }


}