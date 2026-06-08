package StepDef;

import Utils.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DataTableStepDef {

    WebDriver driver = DriverManager.getDriver();

    @When("I am on data table page")
    public void IAmOnDataTablePage() {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @And("the email id for {string} is {string}")
    public void theEmailIdForIs(String LastName, String Email) {

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        int emailIndex = -1;
        int lNameIndex = -1;
        int size = headers.size();
        for(int i = 0; i < size ; i++)
        {
            if (headers.get(i).getText().trim().equals("Last Name"))
            {
                lNameIndex = i+1;
            }
            if (headers.get(i).getText().trim().equals("Email"))
            {
                emailIndex = i+1;
            }
        }

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        String actualEmail = null;
        for(WebElement row : rows)
        {
            String lNameCols = row.findElement(By.xpath("./td["+lNameIndex+"]")).getText();
                if(lNameCols.equals(LastName))
                {
                    actualEmail = row.findElement(By.xpath("./td["+emailIndex+"]")).getText().trim();
        }
        }

        Assert.assertEquals(actualEmail,Email);
    }
}
