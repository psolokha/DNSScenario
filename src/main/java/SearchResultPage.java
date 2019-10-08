import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class SearchResultPage extends AbstractPage{

    @FindBy(xpath = "//*[@data-id = 'catalog-item']")
    List<WebElement> getElements;


    public void addProductToCart(String description) {

        ProductsContainer container = ProductsContainer.getInstance();
        container.addProductToContainer(getElements, description);
        ((WebElement)getElements.stream().
                filter(element -> element.getAttribute("data-position-index").
                        equals(container.getLastAdded().getAttribute("data-position-index"))).toArray()[0]).
                findElement(By.xpath("//descendant::button[1]")).click();
    }

}
