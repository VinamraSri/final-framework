package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownPage extends BasePage{

    WebDriver driver;

    public DropDownPage(WebDriver driver)
    {
        super(driver);
    }

    By dropdown = By.id("dropdown");

    public void selectDropdown(String value)
    {
        selectDropdown(value, dropdown);
    }

    public String getSelectedDropDownValue()
    {
        return getSelectedDropdown(dropdown);
    }
}
