package DataProvider;

import org.testng.annotations.DataProvider;
import orangehrm.Utilities.ExcelUtility;

public class LeaveDataProvider {

    String path = System.getProperty("user.dir")
            + "/src/test/resources/TestData/Leave_TestData.xlsx";




            

    @DataProvider(name = "AssignLeaveData")
    public Object[][] AssignLeaveData(){

        ExcelUtility excel = new ExcelUtility(
                path,
                "LeaveSearch");

        int rows = excel.getRowCount();
        int cols = excel.getColumnCount();

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = excel.getCellData(i, j);

            }
        }

        return data;
    }

}