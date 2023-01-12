package testRunner;

import application.DemoShopApp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class TestRunner {
    public WebDriver driver;
    public DemoShopApp app;
    @BeforeTest
    public void lunchChrome()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        app = new DemoShopApp(driver);
    }

    @Test(priority = 1)
    public void testLoginPage()
    {
        app.loginPage.lunchApplicationAndLogin();
        app.loginPage.verifyLoginPage();
    }

    @Test(priority = 2)
    public void addComputerToCart()
    {
        app.homePage.selectComputers();
        app.computersPage.selectDesktop();
    }

    @Test(priority = 3)
    public void removeItemFromCart()
    {
        app.computersPage.removeFromCart();
    }

    @Test(priority = 4)
    public void addComputerToCar()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        app.homePage.selectComputers();
        app.computersPage.selectDesktop();
        app.computersPage.checkout();
    }

    @Test(priority = 5)
    public void testCheckout()
    {
        app.checkoutPage.verifyCheckoutPage();
    }

    @Test(priority = 6)
    public void checkoutProcess()
    {
        app.checkoutPage.billingAddress();
        app.checkoutPage.testSlip();
    }

    @Test(priority = 7)
    public void logout()
    {
        app.checkoutPage.logOut();
    }

<<<<<<< HEAD


    @AfterTest
    public void closeChrome()
    {

=======
    @AfterTest
    public void closeChrome()
    {
>>>>>>> 4d8cd8b (Initial commit)
        driver.close();
        driver.quit();
    }
}
