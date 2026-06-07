package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadPage extends BasePage{

    public DynamicLoadPage(WebDriver driver)
    {
        super(driver);
    }

    By startButton = By.xpath("//button[text()='Start']");
    By finishMsg = By.id("finish");

    public void ClickOnStartButton()
    {
        click(startButton);
    }

    public String getFinishText()
    {
        return getText(finishMsg);
    }
}
