package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver)
    {
        super(driver);
    }

    public By checkBox(String checkboxNumber)
    {
        return By.xpath("(//input[@type='checkbox'])["+checkboxNumber+"]");
    }

    public void ClickOnCheckbox(String number)
    {
        click(checkBox(number));
    }

    public boolean isCheckboxSelected(String number)
    {
        return driver.findElement(checkBox(number)).isSelected();
    }

}

