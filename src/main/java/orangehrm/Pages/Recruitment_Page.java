package orangehrm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recruitment_Page {

        WebDriver driver;
        WebDriverWait wait;

        public Recruitment_Page(WebDriver driver) {
                this.driver = driver;
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        // Search Candidate Locator //

        By Search_JobTitleDropDown = By.xpath("(//div[normalize-space()='-- Select --'])[1]");

        By Search_VacancyDropDown = By.xpath("(//div[contains(@class,'oxd-select-text')])[4]");

        By Search_HiringManagerDropDown = By.xpath("(//div[contains(@class,'oxd-select-text')])[7]");

        By Search_StatusDropDown = By.xpath("(//div[contains(@class,'oxd-select-text')])[10]");

        By Search_CandidateNameInput = By.xpath("//input[@placeholder='Type for hints...']");

        By Search_KeywordInput = By.xpath("//input[@placeholder='Enter comma seperated words...']");

        By Search_From_DateofApplicationDropDown = By.xpath("//input[@placeholder='From']");

        By Search_To_DateofApplicationDropDown = By.xpath("//input[@placeholder='To']");

        By Search_MethodofApplicationDropDown = By
                        .xpath("(//div[@class='oxd-select-text-input' and normalize-space()='-- Select --'])[5]");

        By searchButton = By.xpath("//button[@type='submit' and normalize-space()='Search']");

        By resetButton = By.xpath("//button[@type='reset' and normalize-space()='Reset']");

        By candidatesTab = By.xpath("//a[normalize-space()='Candidates']");

        // Add Candidate //

        By AddCandidate_Navigator_Button = By.xpath("//button[@type='button' and normalize-space()='Add']");

        By AddCandidate_FirstName = By.xpath("//input[@name='firstName']");

        By AddCandidate_MiddleName = By.xpath("//input[@name='middleName']");

        By AddCandidate_LastName = By.xpath("//input[@name='lastName']");

        By AddCandidate_Vacancy = By
                        .xpath("//div[@class='oxd-select-text-input' and normalize-space()='-- Select --']");

        By AddCandidate_EmailInput = By.xpath("(//input[@placeholder='Type here'])[1]");

        By AddCandidate_ContactNumber = By.xpath("(//input[@placeholder='Type here'])[2]");

        By AddCandidate_Keyword = By.xpath("(//input[@placeholder='Enter comma seperated words...'])[1]");

        By AddCandidate_DateofApplicationDropDown = By.xpath("//input[@placeholder='yyyy-dd-mm']");

        By AddCandidate_Notes = By.xpath("//textarea[@placeholder='Type here']");

        By AddCandidate_SaveButton = By.xpath("//button[@type='submit' and normalize-space()='Save']");

        By AddCandidate_CancelButton = By.xpath("//button[@type='button' and normalize-space()='Cancel']");

        By toastmessage = By.xpath("//p[text()='Successfully Saved']");

        // Result

        By ResultCandidatename = By.xpath("(//div[@role='cell']/div)[3]");

        By ResultVacancy = By.xpath("(//div[@role='cell']/div)[2]");

        By ResultHiringManager = By.xpath("(//div[@role='cell']/div)[4]");

        // Actions Methods //

        // Add Candidate Methods

        public void Navigate_To_AddCandidate() {
                WebElement element = wait.until(
                                ExpectedConditions.elementToBeClickable(AddCandidate_Navigator_Button));

                element.click();
        }

        public void Enter_FirstName_AddCandidate(String Firstname) {

                WebElement element = wait
                                .until(ExpectedConditions.elementToBeClickable(AddCandidate_FirstName));

                element.sendKeys(Firstname);

        }

        public void Enter_MiddleName_AddCandidate(String middleName) {

                WebElement element = wait
                                .until(ExpectedConditions.elementToBeClickable(AddCandidate_MiddleName));

                element.sendKeys(middleName);

        }

        public void Enter_LastName_AddCandidate(String lastName) {

                WebElement element = wait
                                .until(ExpectedConditions.elementToBeClickable(AddCandidate_LastName));

                element.sendKeys(lastName);

        }

        public void Enter_Vacancy_AddCandidate(String vacancy) {

                WebElement element1 = wait
                                .until(ExpectedConditions.elementToBeClickable(AddCandidate_Vacancy));

                element1.click();

                WebElement element2 = wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath("//span[normalize-space()='" + vacancy + "']")));

                element2.click();

        }

        public void Enter_Email_AddCandidate(String email) {

                WebElement element1 = wait
                                .until(ExpectedConditions.elementToBeClickable(AddCandidate_EmailInput));

                element1.sendKeys(email);
        }

        public void Enter_ContactNo_AddCandidate(String contact) {

                WebElement element1 = wait
                                .until(ExpectedConditions.elementToBeClickable(AddCandidate_ContactNumber));

                element1.sendKeys(contact);

        }

        public void Enter_Keyword_AddCandidate(String keyword) {

                WebElement element1 = wait
                                .until(ExpectedConditions.elementToBeClickable(AddCandidate_Keyword));

                element1.sendKeys(keyword);

        }

        public void Enter_DateofApplication_AddCandidate(String date) {

                WebElement element = wait.until(ExpectedConditions
                                .elementToBeClickable(AddCandidate_DateofApplicationDropDown));

                element.click();
                element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                element.sendKeys(Keys.DELETE);
                element.sendKeys(date);

        }

        public void Enter_Notes_AddCandidate(String Notes) {

                WebElement element1 = wait.until(ExpectedConditions
                                .elementToBeClickable(AddCandidate_Notes));

                element1.sendKeys(Notes);

        }

        public void Click_SaveButton_AddCandidate() {

                WebElement element1 = wait.until(ExpectedConditions
                                .elementToBeClickable(AddCandidate_SaveButton));

                element1.click();

        }

        public void Click_CancelButton_AddCandidate() {

                WebElement element1 = wait.until(ExpectedConditions
                                .elementToBeClickable(AddCandidate_CancelButton));

                element1.click();

        }

        public String getToastMessage() {

                return wait.until(
                                ExpectedConditions.visibilityOfElementLocated(toastmessage))
                                .getText();
        }

        // Search Candidate Methods

        public void Click_Jobtitle_SearchCandidate(String job) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Search_JobTitleDropDown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + job + "']")));

                element2.click();

        }

        public void Click_Vacancy_SearchCandidate(String vacancy) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Search_VacancyDropDown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + vacancy + "']")));

                element2.click();

        }

        public void Click_HiringManager_SearchCandidate(String HiringManager) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Search_HiringManagerDropDown));

                element1.click();

                WebElement element2 = wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath("//span[normalize-space()='" + HiringManager + "']")));

                element2.click();

        }

        public void Click_Status_SearchCandidate(String status) {
                WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(Search_StatusDropDown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + status + "']")));

                element2.click();

        }

        public void Click_CandidateName_Search(String name) {

                wait.until(ExpectedConditions.elementToBeClickable(Search_CandidateNameInput)).sendKeys(name);
        }

        public void Click_Keyword_Search(String Keyword) {

                wait.until(ExpectedConditions.elementToBeClickable(Search_KeywordInput)).sendKeys(Keyword);
        }

        public void Click_FromDateofapplication_SearchCandidate(String FromDate) {
                WebElement element1 = wait
                                .until(ExpectedConditions.elementToBeClickable(Search_From_DateofApplicationDropDown));

                element1.sendKeys(FromDate);

                // WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable());

                // element2.sendKeys(FromDate);

        }

        public void Click_ToDateofapplication_SearchCandidate(String ToDate) {
                WebElement element1 = wait
                                .until(ExpectedConditions.elementToBeClickable(Search_To_DateofApplicationDropDown));

                element1.sendKeys(ToDate);

                // WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable());

                // element2.sendKeys(ToDate);

        }

        public void Click_MethodofApplication_SearchCandidate(String method) {
                WebElement element1 = wait
                                .until(ExpectedConditions.elementToBeClickable(Search_MethodofApplicationDropDown));

                element1.click();

                WebElement element2 = wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//span[normalize-space()='" + method + "']")));

                element2.click();

        }

        public void Click_SearchButton_SearchCandidate() {

                wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        }

        public void Click_resetbutton_SearchCandidate() {

                wait.until(ExpectedConditions.elementToBeClickable(resetButton)).click();

                

        }

        public void scrollDown() {

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,300);"); // 300 pixels niche

        }

        public void Select_CandidateSearch_Option(String option) {
                WebElement element = wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath("//span[normalize-space()='" + option + "']")));

                element.click();
        }

        public void clickCandidatesTab() {

                wait.until(ExpectedConditions
                                .elementToBeClickable(candidatesTab)).click();
                ;

        }

        // Result Methods

        public String getResultCandidateName() {

                WebElement element = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(ResultCandidatename));

                return element.getText().trim();
        }

        public String getResultVacancy() {

                WebElement element = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(ResultVacancy));

                return element.getText();
        }

        public String getResultHiringManager() {

                WebElement element = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(ResultHiringManager));

                return element.getText();
        }

        public String getCandidateSearchValue() {

                WebElement element = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(Search_CandidateNameInput));

                return element.getAttribute("value").trim();
        }

}