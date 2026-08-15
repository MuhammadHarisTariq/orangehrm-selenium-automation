package orangehrm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin_Page {

    WebDriver driver;
    WebDriverWait wait;

    public Admin_Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =========================
    // Search User Locators
    // =========================

    By searchby_username = By.xpath("(//input[contains(@class,'oxd-input')])[2]");

    By search_userrole_dropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");
    By search_userrole_admin = By.xpath("(//span[normalize-space()='Admin'])[2]");
    By search_userrole_ess = By.xpath("//span[normalize-space()='ESS']");

    By searchby_employeename = By.xpath("//input[@placeholder='Type for hints...']");

    By searchby_statusdropdown = By
            .xpath("(//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --'])[2]");

    By search_status_enabled = By.xpath("//span[normalize-space()='Enabled']");
    By search_status_disabled = By.xpath("//span[normalize-space()='Disabled']");

    By searchreset_button = By.xpath("//button[normalize-space()='Reset']");
    By search_button = By.xpath("//button[normalize-space()='Search']");
    By adduser_button = By.xpath("//button[normalize-space()='Add']");

    // =========================
    // Verification Locators
    // =========================

    By firstResultUsername = By.xpath("(//div[@role='row'])[2]/div[2]");

    By UserRoleResult = By.xpath("(//div[@role='row'])[2]/div[3]");

    By EmployeeNameResult = By.xpath("(//div[@role='row'])[2]/div[4]");

    By StatusResult = By.xpath("(//div[@role='row'])[2]/div[5]");
    // =========================
    // Search Methods
    // =========================

    public void searchByUsername(String username) {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchby_username));
        element.click();
        element.sendKeys(username);

    }

    public void selectSearchUserRole(String role) {

        wait.until(ExpectedConditions.elementToBeClickable(search_userrole_dropdown)).click();

        if (role.equalsIgnoreCase("Admin")) {

            wait.until(ExpectedConditions.elementToBeClickable(search_userrole_admin)).click();

        } else if (role.equalsIgnoreCase("ESS")) {

            wait.until(ExpectedConditions.elementToBeClickable(search_userrole_ess)).click();
        }
    }

    public void searchByEmployeeName(String employeeName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchby_employeename))
                .sendKeys(employeeName);
    }

    public void selectSearchStatus(String status) {

        wait.until(ExpectedConditions.elementToBeClickable(searchby_statusdropdown)).click();

        if (status.equalsIgnoreCase("Enabled")) {

            wait.until(ExpectedConditions.elementToBeClickable(search_status_enabled)).click();

        } else if (status.equalsIgnoreCase("Disabled")) {

            wait.until(ExpectedConditions.elementToBeClickable(search_status_disabled)).click();
        }
    }

    public void clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(search_button)).click();
    }

    public void clickReset() {

        wait.until(ExpectedConditions.elementToBeClickable(searchreset_button)).click();
    }

    public void clickAddUser() {

        wait.until(ExpectedConditions.elementToBeClickable(adduser_button)).click();
    }

    // =========================
    // Verification Methods
    // =========================

    public String getFirstResultUsername() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstResultUsername))
                .getText().trim();
    }

    public String getResultUserRole() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(UserRoleResult))
                .getText();
    }

    public String getResultEmployeeName() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(EmployeeNameResult))
                .getText();
    }

    public String getResultStatus() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(StatusResult))
                .getText();
    }

    public String getResetvalueofusername() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchby_username))
                .getAttribute("value");
    }

    public void scrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);"); // 300 pixels niche

    }

}