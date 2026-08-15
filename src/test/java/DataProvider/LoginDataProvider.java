package DataProvider;

import org.testng.annotations.DataProvider;

import orangehrm.Utilities.ExcelUtility;

public class LoginDataProvider {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/TestData/LoginData.xlsx";

        ExcelUtility excel = new ExcelUtility(path, "LoginData");

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
}