package StepDef;

import Pages.DashboardPage;
import Pages.LoginPage;
import Utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDef {

    LoginPage login_page = new LoginPage(DriverManager.getDriver());
    DashboardPage dashboard_page = new DashboardPage(DriverManager.getDriver());

    @Given("I am on login page")
    public void iAmOnTheLoginPage() {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/login");
    }

    @When("I enter the username {string} and password {string}")
    public void iEnterUsername(String username, String password) {
        login_page.loginToApplication(username, password);
    }

    @And("I click on {string} button")
    public void iClickTheLoginButton(String button) {
        login_page.clickOnLoginButton(button);
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedMessage) {
        String actualMessage = dashboard_page.getSuccessMsg();

        Assert.assertTrue(
                actualMessage.contains(expectedMessage),
                "Expected message not found. Actual message: " + actualMessage
        );
    }


    @And("I should see the page title {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        Assert.assertEquals(dashboard_page.getPageTitle(), expectedTitle);
    }

    @And("I should see the logout button visible")
    public void theLogoutButtonShouldBeVisible() {
        Assert.assertTrue(dashboard_page.isLogoutButtonDisplayed(), "Logout button not displayed");

    }

    @And("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedError) {
        String actualMsg = login_page.getErrorMsg();
        Assert.assertTrue(actualMsg.contains(expectedError),
                "Expected message not found. Actual message: " + actualMsg);
    }

    @And("I click on logout button")
    public void iClickLogoutButton()
    {
        dashboard_page.clickOnLogoutButton();
    }

    @And("I should redirect to login page")
    public void iShouldRedirectToLoginPage()
    {
        String actualMsg = login_page.getErrorMsg();
        Assert.assertTrue(actualMsg.contains("You logged out of the secure area!"),
                "User is not able to redirect to login page");
    }

}
