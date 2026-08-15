package orangehrm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfo_Page {

    WebDriver driver;
    WebDriverWait wait;

    public MyInfo_Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    By personalDetails = By.xpath("//a[normalize-space()='Personal Details']");

    By firstName = By.xpath("//input[@name='firstName']");

    By middleName = By.xpath("//input[@name='middleName']");

    By lastName = By.xpath("//input[@name='lastName']");

    By saveButton = By.xpath("//button[normalize-space()='Save']");

    By successToast = By.xpath("//div[contains(@class,'oxd-toast--success')]");

    // Methods

    public void clickPersonalDetails() {

        wait.until(ExpectedConditions.elementToBeClickable(personalDetails))
                .click();
    }

    public void enterFirstName(String name) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName));

        element.clear();
        element.sendKeys(name);
    }

    public void enterMiddleName(String name) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(middleName));

        element.clear();
        element.sendKeys(name);
    }

    public void enterLastName(String name) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastName));

        element.clear();
        element.sendKeys(name);
    }

    public void clickSave() {

        wait.until(ExpectedConditions.elementToBeClickable(saveButton))
                .click();
    }

    public String getSuccessToastMessage() {

        WebElement toast = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successToast));

        return toast.getText().trim();
    }
}