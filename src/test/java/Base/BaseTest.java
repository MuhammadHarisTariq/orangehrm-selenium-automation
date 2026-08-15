package orangehrm.Base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        );
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // Screenshot only when test FAILS
        if (result.getStatus() == ITestResult.FAILURE) {

            String className = result.getTestClass()
                    .getRealClass()
                    .getSimpleName();

            String methodName = result.getMethod().getMethodName();

            String timestamp = new SimpleDateFormat(
                    "yyyy-MM-dd_HH-mm-ss"
            ).format(new Date());

            String folderPath = "screenshots/"
                    + className;

            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String filePath = folderPath
                    + "/"
                    + methodName
                    + "_"
                    + timestamp
                    + ".png";

            TakesScreenshot screenshot =
                    (TakesScreenshot) driver;

            File source =
                    screenshot.getScreenshotAs(OutputType.FILE);

            File destination =
                    new File(filePath);

            source.renameTo(destination);

            System.out.println(
                    "Screenshot saved: "
                    + destination.getAbsolutePath()
            );
        }

        if (driver != null) {
            driver.quit();
        }
    }
}