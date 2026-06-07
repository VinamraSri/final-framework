package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver)
    {
        super(driver);
    }

    By logoutButton = By.xpath("//i[contains(text(),'Logout')]");
    By successMsg = By.id("flash");
    By pageTitle = By.xpath("//h2");

    public String getSuccessMsg()
    {
        return getText(successMsg);
    }

    public boolean isLogoutButtonDisplayed()
    {
        return this.driver.findElement(logoutButton).isDisplayed();
    }

    public String getPageTitle()
    {
        return getText(pageTitle);
    }

    public void clickOnLogoutButton()
    {
        click(logoutButton);
    }

}
