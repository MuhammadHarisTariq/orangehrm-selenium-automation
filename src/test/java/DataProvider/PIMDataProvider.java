package DataProvider;

import org.testng.annotations.DataProvider;
import orangehrm.Utilities.ExcelUtility;

public class PIMDataProvider {

    String path = System.getProperty("user.dir")
            + "/src/test/resources/TestData/PIM_TestData.xlsx";

    @DataProvider(name = "AddEmployeeDataProvider")
    public Object[][] AddEmployeeData() {

        ExcelUtility excel = new ExcelUtility(path, "AddEmployee");

        int rows = excel.getRowCount();
        int cols = excel.getColumnCount();

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        excel.closeWorkbook();
        return data;
    }

    @DataProvider(name = "SearchEmployeeNameData")
    public Object[][] SearchEmployeeNameData() {

        ExcelUtility excel = new ExcelUtility(path, "Searchbyname");

        int rows = excel.getRowCount();

        Object[][] data = new Object[rows][1];

        for (int i = 1; i <= rows; i++) {

            data[i - 1][0] = excel.getCellData(i, 0);

        }

        excel.closeWorkbook();

        return data;
    }
}
