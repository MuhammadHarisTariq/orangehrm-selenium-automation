package orangehrm.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    // Constructor
    public ExcelUtility(String filePath, String sheetName) {

        try {

            FileInputStream fis = new FileInputStream(filePath);

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    // Get Total Rows
    public int getRowCount() {

        return sheet.getLastRowNum();

    }

    // Get Total Columns
    public int getColumnCount() {

        Row row = sheet.getRow(0);

        return row.getLastCellNum();

    }

    // Get Cell Data
    public String getCellData(int rowNum, int colNum) {

        DataFormatter formatter = new DataFormatter();

        Cell cell = sheet.getRow(rowNum).getCell(colNum);

        return formatter.formatCellValue(cell);

    }

    // Close Workbook
    public void closeWorkbook() {

        try {

            workbook.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}