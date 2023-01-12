package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ComputersPage {
    private WebDriver _driver;
    public ComputersPage(WebDriver driver)
    {
        this._driver = driver;
        PageFactory.initElements(_driver,this);
    }
    @FindBy(partialLinkText = "Desktops")
    private WebElement desktop;
    @FindBy(partialLinkText = "Notebooks")
    private WebElement notePad;
    @FindBy(id = "products-orderby")
    private WebElement position;
    @FindBy(partialLinkText = "Build your own cheap computer")
    private WebElement cheapComputer;
    @FindBy(xpath = "(//input[@type='radio'])[3]")
    private WebElement processorType;
    @FindBy(xpath = "(//input[@type='radio'])[4]")
    private WebElement ramType;
    @FindBy(xpath = "(//input[@type='radio'])[8]")
    private WebElement hddType;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement softwareType;
    @FindBy(css = "input[class='button-1 add-to-cart-button']")
    private WebElement addToCart;
    @FindBy(partialLinkText = "shopping cart")
    private WebElement shoppingCart;
    @FindBy(xpath = "(//input[@name='removefromcart'])[1]")
    private WebElement removeFromCart;
    @FindBy(xpath = "//input[@name='updatecart']")
    private WebElement updatecart;
    @FindBy(css = "div[class='order-summary-content']")
    private WebElement orderSummaryContent;
    @FindBy(id = "termsofservice")
    private WebElement tcCheckbox;
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id = "products-pagesize")
    private WebElement pageSize;

    public void selectDesktop()
    {
        desktop.click();
        position.click();
        Select sel = new Select(position);
        sel.selectByIndex(1);

        sel.selectByIndex(2);
        sel.selectByIndex(3);
        sel.selectByIndex(4);
        Select pageS = new Select(pageSize);
        pageS.selectByIndex(1);
        pageS.selectByIndex(2);

        cheapComputer.click();
        processorType.click();
        ramType.click();
        hddType.click();
        softwareType.click();
        addToCart.click();
        _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        if(shoppingCart.isEnabled())
        {
            shoppingCart.click();
            System.out.println("Item added to cart");

        }
        else
        {
            System.out.println("Failed to add item to cart");
        }

    }
    public void selectNotepad()
    {
        notePad.click();
    }

    public void removeFromCart()
    {
        _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        removeFromCart.click();
        updatecart.click();
        if(orderSummaryContent.getText().equalsIgnoreCase("Your Shopping Cart is empty!"))
        {
            System.out.println("Item removed from cart");
        }
        else
        {
            System.out.println("Failed to remove item from cart");
        }
    }

    public void checkout()
    {
        tcCheckbox.click();
        checkoutBtn.click();
    }
}
