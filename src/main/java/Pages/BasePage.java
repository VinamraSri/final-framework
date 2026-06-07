package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void click(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void fill(By locator, String text)
    {
        this.driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator)
    {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().trim();
    }

    public void selectDropdown(String dropdown, By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(dropdown);
    }

    public String getSelectedDropdown(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(driver.findElement(locator));
        return select.getFirstSelectedOption().getText().trim();
    }

    public void AcceptAlert()
    {
        driver.switchTo().alert().accept();
    }

    public String getAlertText()
    {
        return driver.switchTo().alert().getText().trim();
    }
}
