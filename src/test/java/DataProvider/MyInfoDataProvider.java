package DataProvider;

import org.testng.annotations.DataProvider;
import orangehrm.Utilities.ExcelUtility;

public class MyInfoDataProvider {

    String path = System.getProperty("user.dir")
            + "/src/test/resources/TestData/MyInfo_TestData.xlsx";

    @DataProvider(name = "PersonalDetailsData")
    public Object[][] PersonalDetailsData() {

        ExcelUtility excel = new ExcelUtility(path, "MyInfo");

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