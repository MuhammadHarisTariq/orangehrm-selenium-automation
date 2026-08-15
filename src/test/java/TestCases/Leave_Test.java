package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.LeaveDataProvider;
import orangehrm.Base.BaseTest;
import orangehrm.Pages.Dashboard_Page;
import orangehrm.Pages.Leave_Page;
import orangehrm.Pages.LoginPage;
import orangehrm.Pages.PIM_Page;

public class Leave_Test extends BaseTest {

        // TC_17 Assign leave to employee
        @Test(dataProvider = "AssignLeaveData", dataProviderClass = LeaveDataProvider.class)
        public void Assign_leavetoEmployee(
                        String employeeName,
                        String leaveType,
                        String fromDate,
                        String toDate,
                        String partialDay,
                        String startDay,
                        String endDay,
                        String comment) {

                try {

                        LoginPage login = new LoginPage(driver);
                        Dashboard_Page dashboard = new Dashboard_Page(driver);
                        Leave_Page leave = new Leave_Page(driver);
                        PIM_Page pim = new PIM_Page(driver);

                        login.login("Admin", "admin123");

                        // Add Employee
                        dashboard.Click_PIM();

                        pim.Navigate_ToAddEmployee();

                        pim.Add_FirstName("Muhammad");
                        pim.Add_MiddleName("Ayyan");
                        pim.Add_LastName("Tariq");

                        pim.Click_Emp_SaveButton();

                        // Assign Leave
                        dashboard.Click_Leave();

                        leave.Assign_Leave_Navigator();

                        leave.Assign_EmployeeName(employeeName);
                        leave.Assign_LeaveType(leaveType);
                        leave.Assign_FromDate_Leave(fromDate);
                        leave.Assign_toDate_Leave(toDate);
                        leave.Assign_PartialDay_Dropdown(partialDay);
                        leave.Assign_StartDay_Dropdown(startDay);
                        leave.Assign_EndDay_Dropdown(endDay);
                        leave.Assign_Comment(comment);

                        leave.Assign_ConfirmOKButton();

                        // Verification
                        Assert.assertEquals(
                                        leave.getToastMessage(),
                                        "Successfully Saved",
                                        "Leave was not assigned successfully");

                } catch (AssertionError e) {

                        Assert.fail(
                                        "Assign Leave assertion failed: "
                                                        + e.getMessage());

                } catch (Exception e) {

                        Assert.fail(
                                        "Assign Leave test failed due to automation error: "
                                                        + e.getMessage());
                }
        }
}