import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

class ProductPage extends AbstractPage{

    private String name;
    private int price;
    private int warranty;

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    int getWarranty() {
        return warranty;
    }

    ProductPage() {

        this.name = productName.getText();
        this.price = setPrice();

        System.out.println(name + ": " + price);
    }


    ProductPage searchOther(String product) {
        waitElement(inputSearch);
        inputSearch.click();
        inputSearch.sendKeys(product);
        inputSearch.sendKeys(Keys.ENTER);
        return new ProductPage();
    }

    void buyWarranty(int years) {
        new Select(driver.findElement(By.xpath("//*[@class='form-control select']"))).selectByValue(String.valueOf(years));
        price = setPrice();
        warranty = years;
    }

    ItemCartPage buyProduct() {
        ProductsContainer.getInstance().addToContainer(this);
        productBuy.click();
        return new ItemCartPage();
    }

    private int setPrice() {
        return Integer.parseInt(productPrice.getText().replace(" ", ""));
    }

    @FindBy(xpath = "//h1[contains(@class, 'page-title')]")
    private WebElement productName;

    @FindBy(xpath = "//div[contains(@class, 'hidden-xs')]//span[contains(@class, 'current-price-value')]")
    private WebElement productPrice;

    @FindBy(xpath = "//button//span[contains(text(), 'Купить')]")
    private WebElement productBuy;


}
