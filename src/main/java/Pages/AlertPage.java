package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver)
    {
        super(driver);
    }

    By alertButton = By.xpath("//button[text()='Click for JS Alert']");

    public void clickOnAlertButton()
    {
        click(alertButton);
    }

    public void acceptAlertPopUp()
    {
        AcceptAlert();
    }

    public String AlertText()
    {
        return getAlertText();
    }
}
