package DataProvider;

import org.testng.annotations.DataProvider;
import orangehrm.Utilities.ExcelUtility;

public class RecruitmentDataProvider {

    String path = System.getProperty("user.dir")
            + "/src/test/resources/TestData/Recruitment_TestData.xlsx";

    @DataProvider(name = "AddCandidateData")
    public Object[][] AddCandidateData() {

        ExcelUtility excel = new ExcelUtility(path, "AddCandidate");

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

    @DataProvider(name = "CandidateSearchData")
    public Object[][] CandidateSearchData() throws Exception {

        ExcelUtility excel = new ExcelUtility(path, "SearchCandidate");

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

    @DataProvider(name = "SearchByVacancyData")
    public Object[][] SearchByVacancyData() {

        ExcelUtility excel = new ExcelUtility(path, "SearchVacancy");

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

    @DataProvider(name = "HiringManagerData")
    public Object[][] HiringManagerData() {

        ExcelUtility excel = new ExcelUtility(path, "HiringManagerSearch");

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

    @DataProvider(name = "JobTitleData")
    public Object[][] JobTitleData() {

        ExcelUtility excel = new ExcelUtility(path, "JobTitleSearch");

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