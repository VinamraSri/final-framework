package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    By userName = By.id("username");
    By userPassword = By.id("password");

    public By getSubmitButton(String button)
    {
        return By.xpath("//button[@type='"+button+"']");
    }
    By errorMsg = By.id("flash");

    public void loginToApplication(String user, String pass)
    {
        fill(userName,user);
        fill(userPassword,pass);
    }

    public void clickOnLoginButton(String button)
    {
        click(getSubmitButton(button));
    }

    public String getErrorMsg()
    {
        return getText(errorMsg);
    }
}
