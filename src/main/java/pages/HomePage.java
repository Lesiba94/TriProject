package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver _driver;
    public HomePage(WebDriver driver)
    {
        this._driver = driver;
        PageFactory.initElements(_driver,this);
    }
    @FindBy(partialLinkText = "COMPUTERS")
    private WebElement computers;
    @FindBy(partialLinkText = "Books")
    private WebElement books;
    public void selectComputers()
    {
        computers.click();
    }
    public void selectBooks()
    {
        books.click();
    }
}
