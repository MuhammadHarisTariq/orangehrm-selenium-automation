package orangehrm.Pages;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Leave_Page {

        WebDriver driver;
        WebDriverWait wait;

        public Leave_Page(WebDriver driver) {

                this.driver = driver;
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }

        // =========================
        // Leave List
        // =========================

        By fromdate_input = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");

        By todate_input = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");

        By leaveStatus_Dropdown = By
                        .xpath("(//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --'])[1]");

        By LeaveRejected = By.xpath("//span[normalize-space()='Rejected']");

        By LeaveCancelled = By.xpath("//span[normalize-space()='Cancelled']");

        By LeavePendingApproval = By.xpath("//span[normalize-space()='Pending Approval']");

        By LeaveScheduled = By.xpath("//span[normalize-space()='Scheduled']");

        By LeaveTaken = By.xpath("//span[normalize-space()='Taken']");

        By leaveTypeDropdown = By.xpath(
                        "(//div[contains(@class,'oxd-select-text-input')])[2]");

        By LeaveType_Can_Breavament = By.xpath("//span[normalize-space()='CAN - Bereavement']");

        By employeeNameInput = By
                        .xpath("//div[contains(@class,'oxd-autocomplete-text-input')]//input[@placeholder='Type for hints...']");

        By SubunitDropdown = By
                        .xpath("(//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --'])[3]");

        By Subunit_Administration = By.xpath("//span[normalize-space()='Administration']");

        By Subunit_Engineering = By.xpath("//span[normalize-space()='Engineering']");

        By btnSearch = By.xpath("//button[normalize-space()='Search']");

        By btnReset = By.xpath("//button[normalize-space()='Reset']");

        // =========================
        // Assign Leave
        // =========================

        By Assign_Leave_Navigator = By.xpath("//a[normalize-space()='Assign Leave']");

        By Assign_employeeNameInput = By
                        .xpath("//div[contains(@class,'oxd-autocomplete-text-input')]//input[@placeholder='Type for hints...']");

        By Assign_leaveTypeDropdown = By
                        .xpath("//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --']");

        By Assign_LeaveTpye_CANBereavement = By.xpath("//span[normalize-space()='CAN - Bereavement']");

        By Assign_From_dateInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");

        By Assign_To_dateInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");

        By Assign_txtComment = By.xpath("//textarea[contains(@class,'oxd-textarea')]");

        By Assign_btnAssign = By.xpath("//button[normalize-space()='Assign']");

        By Assign_PartialDay_Dropdown = By.xpath("(//div[normalize-space()='-- Select --'])[2]");

        By Assign_StartDay_Dropdown = By
                        .xpath("//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --']");

        By Assign_EndDay_Dropdown = By
                        .xpath("//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --']");

        By toastMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]//p[2]");

        // =========================
        // Leave Search Result
        // =========================

        By resultDate = By.xpath("(//div[@role='cell'])[2]/div");

        By resultEmployeeName = By.xpath("(//div[@role='cell'])[3]/div");

        By resultLeaveType = By.xpath("(//div[@role='cell'])[4]/div");

        By resultLeaveBalance = By.xpath("(//div[@role='cell'])[5]/div");

        By resultNumberOfDays = By.xpath("(//div[@role='cell'])[6]/div");

        By resultStatus = By.xpath("(//div[@role='cell'])[7]/div");

        By noRecordFound = By.xpath("//span[normalize-space()='No Records Found']");

        // Search Leave

        public void Click_FromDate_LeaveSearch(String fromDate) {
                wait.until(ExpectedConditions.elementToBeClickable(fromdate_input)).sendKeys(fromDate);
        }

        public void Click_ToDate_LeaveSearch(String toDate) {

                wait.until(ExpectedConditions.elementToBeClickable(todate_input)).sendKeys(toDate);

        }

        public void Click_LeaveStatusDropdown_Search(String status) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(leaveStatus_Dropdown));

                element1.click();

                WebElement element2 = wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath("//span[normalize-space()='" + status + "']")));

                element2.click();
        }

        public void Click_LeaveType_Search(String type) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + type + "']")));

                element2.click();
        }

        public void Click_EmployeeName_Search(String Name) {

                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(employeeNameInput));

                element1.sendKeys(Name);

        }

        public void Click_Subunit_Search(String unit) {

                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(SubunitDropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + unit + "']")));

                element2.click();

        }

        public void Click_SearchButton() {

                wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();

        }

        public void Click_ResetButton() {

                wait.until(ExpectedConditions.elementToBeClickable(btnReset)).click();

        }

        public void scrollDown() {

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,300);"); // 300 pixels niche

        }

        // Assign Leave

        public void Assign_Leave_Navigator() {
                wait.until(ExpectedConditions.elementToBeClickable(Assign_Leave_Navigator)).click();

        }

        public void Assign_EmployeeName(String name) {

                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Assign_employeeNameInput));

                element1.click();
                element1.sendKeys(name);

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='Muhammad Ayyan Tariq']")));

                element2.click();

        }

        public void Assign_LeaveType(String type) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Assign_leaveTypeDropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + type + "']")));

                element2.click();
        }

        public void Assign_FromDate_Leave(String fromDate) {

                WebElement element = wait.until(
                                ExpectedConditions.elementToBeClickable(Assign_From_dateInput));

                element.click();
                element.sendKeys(Keys.CONTROL, "a");
                element.sendKeys(Keys.DELETE);
                element.sendKeys(fromDate);
        }

        public void Assign_toDate_Leave(String toDate) {

                WebElement element = wait.until(
                                ExpectedConditions.elementToBeClickable(Assign_To_dateInput));

                element.click();

                element.sendKeys(Keys.CONTROL, "a");
                element.sendKeys(Keys.DELETE);

                
                
                element.sendKeys(toDate);

                driver.findElement(By.xpath("//body")).click();
                
        }

        public void Assign_Comment(String comment) {

                wait.until(ExpectedConditions.elementToBeClickable(Assign_txtComment)).sendKeys(comment);

        }

        public void Assign_PartialDay_Dropdown(String Day) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Assign_PartialDay_Dropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + Day + "']")));

                element2.click();

        }

        public void Assign_StartDay_Dropdown(String Day) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Assign_StartDay_Dropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + Day + "']")));

                element2.click();

        }

        public void Assign_EndDay_Dropdown(String Day) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Assign_EndDay_Dropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + Day + "']")));

                element2.click();

        }

        public void Assign_AddButton() {

                wait.until(ExpectedConditions.elementToBeClickable(Assign_btnAssign)).click();

        }

        public void Assign_ConfirmOKButton() {

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Ok']")))
                                .click();

        }

        public String getToastMessage() {

                return wait.until(ExpectedConditions.elementToBeClickable(toastMessage)).getText();

        }

}