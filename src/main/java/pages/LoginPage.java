package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver _driver;
    public LoginPage(WebDriver driver)
    {
        this._driver = driver;
        PageFactory.initElements(_driver,this);
    }
    @FindBy(css = "a[class='ico-login']")
    private WebElement loginBtn;
    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(id = "Password")
    private WebElement password;
    @FindBy(css = "input[class='button-1 login-button']")
    private WebElement log_In_Btn;
    @FindBy(linkText = "lamasekoameng@gmail.com")
    private WebElement username;
    public void lunchApplicationAndLogin()
    {
        _driver.navigate().to("https://demowebshop.tricentis.com/");
        loginBtn.click();
        email.sendKeys("lamasekoameng@gmail.com");
        password.sendKeys("674999305");
        log_In_Btn.click();
    }

    public void verifyLoginPage()
    {
        String ActualUsername = "lamasekoameng@gmail.com";
        String expectedUsername = username.getText();

        if(ActualUsername.equalsIgnoreCase(expectedUsername))
        {
           System.out.println(ActualUsername + ", logged in successfully");
        }
        else
        {
            System.out.println("Failed to login");
        }
    }
}
