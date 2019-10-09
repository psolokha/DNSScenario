import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class AbstractPage {

    WebDriver driver;

    AbstractPage(){
        this.driver = InitDriver.getInstance();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav//input")
    WebElement inputSearch;

    @FindBy(xpath = "//nav//span[@data-of='totalPrice']")
    private WebElement buttonCart;

    @FindBy(xpath = "//title[text() != '']")
    WebElement titleText;

    ItemCartPage goToCart() {
        buttonCart.click();
        return new ItemCartPage();
    }

    void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    void waitElement(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    SearchResultPage searchItem(String item) {
        waitElement(inputSearch);
        inputSearch.click();
        inputSearch.sendKeys(item);
        inputSearch.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }


}
