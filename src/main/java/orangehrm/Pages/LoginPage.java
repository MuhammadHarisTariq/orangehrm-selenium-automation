package orangehrm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Locators

    By username = By.name("username");

    By password = By.name("password");

    By login_button = By.xpath("//button[@type='submit' and normalize-space()='Login']");

    By login_form = By.className("orangehrm-login-form");

    By label_errormessage = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");

    By forget_password = By.xpath("//p[normalize-space()='Forgot your password?']");


    // =========================
    // Action Methods
    // =========================


    public void enterUsername(String my_username) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(username))
            .clear();

        driver.findElement(username)
            .sendKeys(my_username);

    }


    public void enterPassword(String my_password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
            .clear();

        driver.findElement(password)
            .sendKeys(my_password);

    }


    public void clickLogin() {

        wait.until(ExpectedConditions.elementToBeClickable(login_button))
            .click();

    }


    public void login(String my_username, String my_password) {

        enterUsername(my_username);
        enterPassword(my_password);
        clickLogin();

        wait.until(
        ExpectedConditions.urlContains("dashboard")
    );

    }


    public void clickForgotPassword() {

        wait.until(ExpectedConditions.elementToBeClickable(forget_password))
            .click();

    }


    public boolean isLoginPageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(login_form)
        ).isDisplayed();

    }


    public String getErrorMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(label_errormessage)
        ).getText();

    }

}