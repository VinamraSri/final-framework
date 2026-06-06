package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By userName = By.id("username");
    By userPassword = By.id("password");

    public By getSubmitButton(String button)
    {
        return By.xpath("//button[@type='"+button+"']");
    }
    By submitButton = By.xpath("//button[@type='submit']");
    By errorMsg = By.id("flash");

    public void loginToApplication(String user, String pass)
    {
        this.driver.findElement(userName).sendKeys(user);
        this.driver.findElement(userPassword).sendKeys(pass);
    }

    public void clickOnLoginButton(String button)
    {
        this.driver.findElement(getSubmitButton(button)).click();
    }

    public String getErrorMsg()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return this.driver.findElement(errorMsg).getText().trim();
    }
}
