import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsContainer {


    private List<WebElement> productsContainer;
    private static ProductsContainer instance;

    private ProductsContainer(){
        productsContainer = new ArrayList<>();
    }

    public static ProductsContainer getInstance() {
        return instance == null ? instance = new ProductsContainer() : instance;
    }

    public WebElement getLastAdded() {
        return productsContainer.get(productsContainer.size()-1);
    }

    public void addProductToContainer(List<WebElement> productsList, String description) {
        productsContainer.add((WebElement) productsList.stream().filter(product -> {
            return product.getText().contains(description);
        }).toArray()[0]);
    }

    public void removeProductFromContainer(WebElement element) {
        productsContainer.remove(element);
    }

//    private int price;
//    private int warranty;
//    private String description;
//
//    public ProductsContainer(int price, String description) {
//        this.price = price;
//        this.description = description;
//    }
//
//    public ProductsContainer(int price, String description, int warranty) {
//        this(price, description);
//        this.warranty = warranty;
//    }
}
