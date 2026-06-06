package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    By logoutButton = By.xpath("//i[contains(text(),'Logout')]");
    By successMsg = By.id("flash");
    By pageTitle = By.xpath("//h2");

    public String getSuccessMsg()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        return this.driver.findElement(successMsg).getText().trim();
    }

    public boolean isLogoutButtonDisplayed()
    {
        return this.driver.findElement(logoutButton).isDisplayed();
    }

    public String getPageTitle()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return this.driver.findElement(pageTitle).getText().trim();
    }

    public void clickOnLogoutButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        this.driver.findElement(logoutButton).click();
    }

}
