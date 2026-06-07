package StepDef;

import Pages.DynamicLoadPage;
import Utils.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DynamicLoadingStepDef {

    DynamicLoadPage dynamicloading_page = new DynamicLoadPage(DriverManager.getDriver());

    @When("I am on dynamic loading page")
    public void IAmOnDynamicLoadingPage()
    {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @And("I click on start button")
    public void iClickOnStartButton() {

        dynamicloading_page.ClickOnStartButton();
    }

    @Then("I see the {string}")
    public void iSeeThe(String expectedMsg) {

        String actualMsg = dynamicloading_page.getFinishText();
        if(!actualMsg.equals(expectedMsg))
        {
            throw new RuntimeException("Failed");
        }

    }
}
