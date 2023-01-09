package application;

import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.ComputersPage;
import pages.HomePage;
import pages.LoginPage;

public class DemoShopApp {
    public LoginPage loginPage;
    public HomePage homePage;
    public ComputersPage computersPage;
    public CheckoutPage checkoutPage;
    public DemoShopApp(WebDriver driver)
    {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        computersPage = new ComputersPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
}
