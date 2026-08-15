package orangehrm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard_Page {

    WebDriver driver;
    WebDriverWait wait;

    public Dashboard_Page(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Locators

    By dashboard_text = By.xpath("//h6[normalize-space()='Dashboard']");

    By admin = By.xpath("//span[normalize-space()='Admin']");

    By pim = By.xpath("//span[normalize-space()='PIM']");

    By leave = By.xpath("//span[normalize-space()='Leave']");

    By recruitment = By.xpath("//span[normalize-space()='Recruitment']");

    By myinfo = By.xpath("//span[normalize-space()='My Info']");

    By buzz = By.xpath("//span[normalize-space()='Buzz']");

    By search_bar = By.xpath("//input[@placeholder='Search']");

    By Profile = By.xpath("//p[contains(@class,'oxd-userdropdown-name')]");

    By logout = By.xpath("//a[contains(text(),'Logout')]");

    By getloggedin_username = By.xpath("//p[contains(@class,'oxd-userdropdown-name')]");

    // Methods

    public boolean Dashboard_Display() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboard_text)).isDisplayed();

    }

    public void Click_Admin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(admin)).click();

    }

    public void Click_PIM() {

        wait.until(
                ExpectedConditions.elementToBeClickable(pim)).click();

    }

    public void Click_Leave() {

        wait.until(
                ExpectedConditions.elementToBeClickable(leave)).click();

    }

    public void Click_Recruitment() {

        wait.until(
                ExpectedConditions.elementToBeClickable(recruitment)).click();

    }

    public void Click_Myinfo() {

        wait.until(
                ExpectedConditions.elementToBeClickable(myinfo)).click();

    }

    public void Click_Buzz() {

        wait.until(
                ExpectedConditions.elementToBeClickable(buzz)).click();

    }

    public void Search_Menu(String menu_name) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(search_bar)).sendKeys(menu_name);

    }

    public void logout() {

        // Open profile dropdown
        wait.until(
                ExpectedConditions.elementToBeClickable(Profile)).click();

        // Click logout
        wait.until(
                ExpectedConditions.elementToBeClickable(logout)).click();

    }

    public String getloggedIn_Username() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(getloggedin_username)).getText();

    }

    // Backward compatibility k liye
    public void Click_Pim() {

        Click_PIM();

    }

}