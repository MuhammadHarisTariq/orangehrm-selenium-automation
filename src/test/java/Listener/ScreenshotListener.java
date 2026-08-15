package orangehrm.Listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import orangehrm.Base.BaseTest;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        try {

            BaseTest testClass = (BaseTest) result.getInstance();

            WebDriver driver = testClass.driver;

            if (driver == null) {
                return;
            }

            String className = result.getTestClass()
                    .getRealClass()
                    .getSimpleName();

            String methodName = result.getMethod()
                    .getMethodName();

            String timestamp = new SimpleDateFormat(
                    "yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());

            String folderPath = System.getProperty("user.dir")
                    + "/screenshots/failed/";

            String fileName = className
                    + "_" + methodName
                    + "_" + timestamp
                    + ".png";

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File destination = new File(
                    folderPath + fileName);

            FileUtils.copyFile(source, destination);

            System.out.println(
                    "Screenshot saved: "
                    + destination.getAbsolutePath());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}