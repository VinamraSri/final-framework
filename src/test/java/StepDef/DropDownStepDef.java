package StepDef;

import Pages.DropDownPage;
import Utils.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DropDownStepDef {

    DropDownPage dropdown_page = new DropDownPage(DriverManager.getDriver());

    @When("I am on dropdown page")
    public void IamOnDropDownPage()
    {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/dropdown");
    }

    @And("I select {string} from dropdown")
    public void iSelectFromDropdown(String value) {

        dropdown_page.selectDropdown(value);
    }

    @Then("I see the {string} selected")
    public void iSeeTheSelected(String value) {

        String actualValue = dropdown_page.getSelectedDropDownValue();
        Assert.assertEquals(actualValue, value);
    }
}
