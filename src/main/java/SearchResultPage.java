import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

class SearchResultPage extends AbstractPage{

    @FindBy(xpath = "//*[@data-id = 'catalog-item']")
    List<WebElement> getElements;

    ProductPage chooseProduct(String product) {
        clickElement("//*[contains(text(), '" + product + "')]");
        return new ProductPage();
    }

}
