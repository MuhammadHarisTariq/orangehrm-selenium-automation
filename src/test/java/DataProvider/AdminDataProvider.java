package DataProvider;

import org.testng.annotations.DataProvider;

import orangehrm.Utilities.ExcelUtility;

public class AdminDataProvider {

    @DataProvider(name = "UserNameData")
    public Object[][] getUserNameData() {
        String path = System.getProperty("user.dir") + ("/src/test/resources/TestData/AdminData.xlsx");

        ExcelUtility excel = new ExcelUtility(path, "AdminData");

        int row = excel.getRowCount();
        // int column = excel.getColumnCount();

        Object[][] data = new Object[row][1];

        for (int i = 1; i <= row; i++) {

           data[i - 1][0] = excel.getCellData(i, 0);

        }

        excel.closeWorkbook();

        return data;
    }

    @DataProvider(name = "UserRoleData")
    public Object[][] getUserRoleData() {
        String path = System.getProperty("user.dir") + ("/src/test/resources/TestData/AdminData.xlsx");

        ExcelUtility excel = new ExcelUtility(path, "AdminData");

        int row = excel.getRowCount();
        // int column = excel.getColumnCount();

        Object[][] data = new Object[row][1];

        for (int i = 1; i <= row; i++) {

            data[i - 1][0] = excel.getCellData(i, 1);

        }

        excel.closeWorkbook();

        return data;
    }

    @DataProvider(name="EmployeeNameData")
    public Object[][] EmployeeNameData(){
        String path = System.getProperty("user.dir")+("/src/test/resources/TestData/AdminData.xlsx");

        ExcelUtility excel = new ExcelUtility(path, "AdminData");

        int row = excel.getRowCount();

        Object[][] data = new Object[row][1];

        for (int i = 1; i <= row ; i++) {

            data[i - 1][0] = excel.getCellData(i, 2);
            
        }

        excel.closeWorkbook();

        return data;
    
    }

    @DataProvider(name="StatusData")
    public Object [][] StatusData(){
        String path = System.getProperty("user.dir")+("/src/test/resources/TestData/AdminData.xlsx");

        ExcelUtility excel = new ExcelUtility(path, "AdminData");

        int row = excel.getRowCount();

        Object [][] data = new Object[row][1];

        for (int i = 1; i <= row; i++) {

            data[i - 1][0] = excel.getCellData(i, 3);
            
        }

        excel.closeWorkbook();

        return data;

    }

}
