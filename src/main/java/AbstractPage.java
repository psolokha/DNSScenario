import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(){
        this.driver = InitDriver.getInstance();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav//input")
    WebElement inputSearch;

    @FindBy(xpath = "//a[@class = 'btn-cart-link']")
    WebElement buttonCart;

    @FindBy(tagName = "title")
    WebElement titleText;

    public ItemCartPage goToCart() {
        buttonCart.click();
        return new ItemCartPage();
    }

    public void waitElement(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }


}
