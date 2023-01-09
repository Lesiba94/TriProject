package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private WebDriver _driver;
    public CheckoutPage(WebDriver driver)
    {
        this._driver = driver;
        PageFactory.initElements(_driver,this);
    }

    @FindBy(css = "div[class='page-title']")
    private WebElement pageTitle;
    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement country;
    @FindBy(id = "BillingNewAddress_City")
    private WebElement city;
    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement addressLine1;
    @FindBy(id = "BillingNewAddress_Address2")
    private WebElement addressLine2;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement addressCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;
    @FindBy(xpath = "(//input[@title='Continue'])[1]")
    private WebElement Continue;
    @FindBy(xpath = "(//input[@title='Continue'])[2]")
    private WebElement Continue2;
    @FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
    private WebElement Continue3;
    @FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
    private WebElement Continue4;
    @FindBy(css = "input[class='button-1 payment-info-next-step-button']")
    private WebElement Continue5;
    @FindBy(css = "input[class='button-1 confirm-order-next-step-button']")
    private WebElement confirm;
    @FindBy(css = "div[class='title']")
    private WebElement title;
    @FindBy(css = "input[class='button-1 payment-method-next-step-button']")
    private WebElement validAddress;
    @FindBy(partialLinkText = "Click here for order details.")
    private WebElement OrderDetails;
    @FindBy(partialLinkText = "PDF Invoice")
    private WebElement pdfInvoice;
    @FindBy(css = "a[class='ico-logout']")
    private WebElement logout;

    public void verifyCheckoutPage()
    {
        if(pageTitle.getText().equalsIgnoreCase("Checkout"))
        {
            System.out.println("Checkout page is successfully open");
        }
        else
        {
            System.out.println("Checkout page didn't open");
        }
    }

    public void billingAddress()
    {

        if(validAddress.isEnabled())
        {
            Continue.click();
            System.out.println("Valid address is selected");
        }
        else
        {
            country.click();
            Select select = new Select(country);
            select.selectByVisibleText("South Africa");
            city.sendKeys();
            addressLine1.sendKeys("PO Box 419");
            addressLine2.sendKeys("Sengatane");
            addressCode.sendKeys("0808");
            phoneNumber.sendKeys("0826426590");
        }

        Continue2.click();
        Continue3.click();
        Continue4.click();
        Continue5.click();
        confirm.click();

        if(title.getText().equalsIgnoreCase("Your order has been successfully processed!"))
        {
            System.out.println("Order is successfully processed!!");
        }
        else
        {
            System.out.println("Failed to order item successfully");
        }
    }

    public void testSlip()
    {
        OrderDetails.click();
        pdfInvoice.click();
    }

    public void logOut()
    {
        logout.click();
    }
}
