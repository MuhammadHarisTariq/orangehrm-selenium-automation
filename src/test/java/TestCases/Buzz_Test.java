package TestCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.Base.BaseTest;
import orangehrm.Pages.Buzz_Page;
import orangehrm.Pages.Dashboard_Page;
import orangehrm.Pages.LoginPage;

public class Buzz_Test extends BaseTest {

    // TC_20 Create new post
    // TC_21 Verify created post is displayed
    @Test
    public void CreateNewPost() {

        try {

            LoginPage mylogin = new LoginPage(driver);
            Dashboard_Page mydash = new Dashboard_Page(driver);
            Buzz_Page buzz = new Buzz_Page(driver);

            String post = "Hi Muhammad Haris Tariq Here";

            mylogin.login("Admin", "admin123");

            mydash.Click_Buzz();

            buzz.writepost(post);
            buzz.postbutton();

            Assert.assertEquals(
                    buzz.getmypostcontent(),
                    post,
                    "Created post content does not match expected post");

        } catch (AssertionError e) {

            Assert.fail(
                    "Create New Post assertion failed: "
                            + e.getMessage());

        } catch (Exception e) {

            Assert.fail(
                    "Create New Post failed due to automation error: "
                            + e.getMessage());
        }
    }

    // TC_22 Comment on post
    @Test
    public void CreateComment() {

        try {

            LoginPage mylogin = new LoginPage(driver);
            Dashboard_Page mydash = new Dashboard_Page(driver);
            Buzz_Page buzz = new Buzz_Page(driver);

            String post = "Hi Muhammad Haris Tariq Here";
            String comment = "My First Comment";

            mylogin.login("Admin", "admin123");

            mydash.Click_Buzz();

            // Create Post
            buzz.writepost(post);
            buzz.postbutton();

            // Comment on the post
            buzz.Click_CommentButton();

            buzz.Write_Comment(comment);

            buzz.pressEnterOnComment();

            // Verify comment
            Assert.assertEquals(
                    buzz.getmyCommentcontent(),
                    comment);

        } catch (AssertionError e) {

            Assert.fail("Comment assertion failed: " + e.getMessage());

        } catch (Exception e) {

            Assert.fail("Comment test failed due to automation error: "
                    + e.getMessage());
        }
    }

    // TC_23 Like a post
    @Test
    public void LikePost() {

        try {

            LoginPage login = new LoginPage(driver);
            Dashboard_Page dashboard = new Dashboard_Page(driver);
            Buzz_Page buzz = new Buzz_Page(driver);

            login.login("Admin", "admin123");

            dashboard.Click_Buzz();

            buzz.LikePostButton();

            Assert.assertTrue(
                    buzz.getLikeCount() >= 1,
                    "Like count should be greater than or equal to 1");

        } catch (AssertionError e) {

            Assert.fail("Like assertion failed: " + e.getMessage());

        } catch (Exception e) {

            Assert.fail(
                    "Like test failed due to automation error: "
                            + e.getMessage());
        }
    }

}
