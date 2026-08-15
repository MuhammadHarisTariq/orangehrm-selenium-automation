package orangehrm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIM_Page {

        WebDriver driver;
        WebDriverWait wait;

        public PIM_Page(WebDriver driver) {
                this.driver = driver;
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        // =============================
        // Search Employee Locators
        // =============================

        By search_employeename_input = By.xpath("(//input[@placeholder='Type for hints...'])[1]");

        By search_employeeid_input = By.xpath("(//input[contains(@class,'oxd-input')])[2]");

        By search_employeeStatusDropdown = By.xpath(
                        "(//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --'])[1]");

        By Include_Dropdown = By.xpath(
                        "//div[contains(@class,'oxd-select-text-input') and normalize-space()='Current Employees Only']");

        By supervisorname_input = By.xpath("(//input[@placeholder='Type for hints...'])[2]");

        By Jobdropdown = By.xpath(
                        "(//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --'])[2]");

        By SubUnitDropdown = By.xpath(
                        "(//div[contains(@class,'oxd-select-text-input') and normalize-space()='-- Select --'])[3]");

        By SearchButton = By.xpath("//button[normalize-space()='Search']");

        By ResetButton = By.xpath("//button[normalize-space()='Reset']");

        // =============================
        // Add Employee Locators
        // =============================

        By AddEmployee = By.xpath("//button[normalize-space()='Add']");

        By Employee_Firstname = By.xpath("//input[@name='firstName']");

        By Employee_Middlename = By.xpath("//input[@name='middleName']");

        By Employee_Lastname = By.xpath("//input[@name='lastName']");

        By Employee_Id = By.xpath("(//input[contains(@class,'oxd-input')])[5]");

        By Employee_savebutton = By.xpath("//button[normalize-space()='Save']");

        By Employee_cancelbutton = By.xpath("//button[normalize-space()='Cancel']");

        By successMessage = By.xpath("//p[text()='Successfully Saved']");

        By formLoader = By.cssSelector(".oxd-form-loader");

        // Search Result Table (First Data Row)

        By resultEmployeeId = By.xpath("(//div[@role='row'])[2]//div[@role='cell'][2]");

        By resultFirstMiddleName = By.xpath("(//div[@role='row'])[2]//div[@role='cell'][3]");

        By resultLastName = By.xpath("(//div[@role='row'])[2]//div[@role='cell'][4]");

        By resultJobTitle = By.xpath("(//div[@role='row'])[2]//div[@role='cell'][5]");

        By resultEmploymentStatus = By.xpath("(//div[@role='row'])[2]//div[@role='cell'][6]");

        By resultSubUnit = By.xpath("(//div[@role='row'])[2]//div[@role='cell'][7]");

        By noRecordFound = By.xpath("//span[normalize-space()='No Records Found']");

        // ------- Actions Methods -------//

        // Search Employee Methods

        public void Click_EmployeeName(String name) {

                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(search_employeename_input));

                element.click();

                element.sendKeys(name);

        }

        public void Click_EmployeeID(String Employee_ID) {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(search_employeeid_input));

                element.click();

                element.sendKeys(Employee_ID);
        }

        public void Click_EmploymentStatus(String EmployementStatus) {
                WebElement element1 = wait
                                .until(ExpectedConditions.elementToBeClickable(search_employeeStatusDropdown));

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + EmployementStatus + "']")));

                element2.click();

        }

        public void Click_Include_CurrentEmployee(String Include) {

                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Include_Dropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + Include + "']")));

                element2.click();

        }

        public void Click_Supervisor_Input(String Supervisorname) {

                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(supervisorname_input));

                element1.click();

                element1.sendKeys(Supervisorname);

        }

        public void Click_JobTitleDropDown(String Job) {

                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Jobdropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + Job + "']")));

                element2.click();

        }

        public void Click_Subunit(String subunit) {

                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(SubUnitDropdown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + subunit + "']")));

                element2.click();

        }

        public void Click_SearchButton() {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(SearchButton));

                element1.click();

        }

        public void clickReset() {

                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(ResetButton));

                element1.click();

        }

        public String getGeneratedEmployeeId() {

                WebElement empId = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(Employee_Id));

                return empId.getAttribute("value");
        }

        public String getEmployeeNameValue() {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(search_employeename_input))
                                .getAttribute("value");
        }

        // Add Employee Methods

        public void Navigate_ToAddEmployee() {

                wait.until(ExpectedConditions.visibilityOfElementLocated(AddEmployee)).click();
        }

        public void Add_FirstName(String firstName) {
                wait.until(ExpectedConditions.elementToBeClickable(Employee_Firstname)).sendKeys(firstName);
        }

        public void Add_MiddleName(String middleName) {

                wait.until(ExpectedConditions.elementToBeClickable(Employee_Middlename)).sendKeys(middleName);

        }

        public void Add_LastName(String lastName) {

                wait.until(ExpectedConditions.elementToBeClickable(Employee_Lastname)).sendKeys(lastName);
        }

        // public void Add_EmployeeID(String EmployeeID) {

        // wait.until(ExpectedConditions.elementToBeClickable(Employee_Id)).sendKeys(EmployeeID);

        // }

        public void Click_Emp_SaveButton() {

                // Wait until loader disappears
                wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));

                WebElement save = wait.until(ExpectedConditions.elementToBeClickable(Employee_savebutton));

                save.click();
        }

        public void Click_Emp_CancelButton() {

                wait.until(ExpectedConditions.elementToBeClickable(Employee_cancelbutton)).click();
        }

        public boolean isEmployeeAdded() {

                By successMessage = By.xpath("//p[text()='Successfully Saved']");

                try {
                        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage))
                                        .isDisplayed();
                } catch (Exception e) {
                        return false;
                }
        }

        // Result list

        public void scrollDown() {

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,300);"); // 300 pixels niche

        }

        public String Result_EmpFirstMiddleName() {
                String result_FirstMiddlename = wait
                                .until(ExpectedConditions.visibilityOfElementLocated(resultFirstMiddleName))
                                .getText();

                return result_FirstMiddlename;
        }

        public String Result_EmpLastName() {
                String result_Lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(resultLastName))
                                .getText();

                return result_Lastname;
        }

        public String Result_EmpId() {
                String result_id = wait.until(ExpectedConditions.visibilityOfElementLocated(resultEmployeeId))
                                .getText();

                return result_id;
        }
}