package orangehrm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buzz_Page {

        WebDriver driver;
        WebDriverWait wait;

        public Buzz_Page(WebDriver driver) {
                this.driver = driver;
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }

        // Create Post

        By postTextarea = By.xpath(
                        "//textarea[contains(@placeholder,'What')]");

        By postButton = By.xpath(
                        "//button[normalize-space()='Post']");

        By MyPostContent = By.xpath("(//p[contains(@class,'orangehrm-buzz-post-body-text')])[1]");

        // =========================
        // Feed Actions
        // =========================


        By likeButton = By.id("heart-svg");

        By commentInput = By.xpath(
                        "//input[@placeholder='Write your comment...']");

        By commentButton = By.xpath(
                        "(//button[contains(@class,'oxd-icon-button')])[4]");

        By getmyCommentcontent = By.xpath("//span[contains(@class,'orangehrm-post-comment-text')]");

        // Like Post

        By Likepost = By.xpath("//svg[@id='heart-svg']/g[@id='Group']/path[@id='heart']");

        By likeCount = By.xpath("//p[contains(@class,'orangehrm-buzz-stats-active')]");

        // Action Methods //

        // click on post button

        public void postbutton() {
                wait.until(ExpectedConditions.elementToBeClickable(postButton)).click();

        }

        // Enter Post
        public void writepost(String text) {

                wait.until(ExpectedConditions.elementToBeClickable(postTextarea)).sendKeys(text);

        }

        // My Post Content for validate that post has posted or not

        public String getmypostcontent() {

                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(MyPostContent));

                return element.getText().trim();

        }

        // Click on Comment Button

        public void Click_CommentButton() {

                wait.until(ExpectedConditions.visibilityOfElementLocated(commentButton)).click();

        }

        public void Write_Comment(String comment) {

                wait.until(ExpectedConditions.visibilityOfElementLocated(commentInput)).sendKeys(comment);

        }

        public String getmyCommentcontent() {

                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getmyCommentcontent));

                return element.getText().trim();

        }

        public void pressEnterOnComment() {
                wait.until(ExpectedConditions.elementToBeClickable(commentInput))
                                .sendKeys(Keys.ENTER);
        }

        // Like Post 

        public void LikePostButton() {
                wait.until(ExpectedConditions.elementToBeClickable(likeButton))
                                .click();
                ;

        }

        public int getLikeCount() {

                WebElement element = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(likeCount));

                String text = element.getText().trim();

                return Integer.parseInt(text.replaceAll("\\D+", ""));
        }
}