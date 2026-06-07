package StepDef;

import Pages.AlertPage;
import Utils.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AlertStepDef {

    public AlertPage alert_page = new AlertPage(DriverManager.getDriver());

    @When("I am on alert page")
    public void IAMOnAlertPage()
    {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @And("I accept the alert")
    public void iAcceptTheAlert() {

        alert_page.acceptAlertPopUp();
    }

    @Then("I see the alert message {string}")
    public void iSeeTheAlertMessage(String expectedMsg) {

        String actualMsg = alert_page.getAlertText();
        Assert.assertEquals(actualMsg,expectedMsg);
    }

    @And("I click on Alert button")
    public void iClickOnAlertButton() {

        alert_page.clickOnAlertButton();
    }
}
