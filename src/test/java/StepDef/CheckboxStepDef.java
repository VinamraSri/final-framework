package StepDef;

import Pages.CheckboxesPage;
import Utils.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckboxStepDef {

    CheckboxesPage checkbox_page = new CheckboxesPage(DriverManager.getDriver());

    @When("I am on checkbox page")
    public void IamOnCheckBoxPage()
    {
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Then ("I check the checkbox number {string}")
    public void ICheckTheCheckbox(String number)
    {
        checkbox_page.ClickOnCheckbox(number);
    }

    @And("checkbox {string} should be selected")
    public void checkBoxSelected(String number)
    {
        boolean status = checkbox_page.isCheckboxSelected(number);
        Assert.assertTrue(status,"Checkbox "+number+" is not selected");
    }

    @And("I wait for {int} second")
    public void iWaitForSecond(int sec) throws InterruptedException {

        Thread.sleep(sec* 1000);
    }
}
