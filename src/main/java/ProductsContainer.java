import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ProductsContainer {


    private List<ProductPage> productsContainer;
    private List<ProductPage> removedItems;
    private static ProductsContainer instance;

    private ProductsContainer(){
        productsContainer = new ArrayList<>();
        removedItems = new ArrayList<>();
    }

    static ProductsContainer getInstance() {
        return instance == null ? instance = new ProductsContainer() : instance;
    }

    void addToContainer(ProductPage product) {
        productsContainer.add(product);
    }

    void addAllRemovedItems() {
        productsContainer.addAll(removedItems);
    }

    void removeFromContainer(String product) {
        removedItems.add(getItem(product));
        productsContainer = productsContainer.stream().filter(c -> !c.getName().contains(product)).collect(Collectors.toList());
    }

    ProductPage getItem(String product) {
        return (ProductPage) productsContainer.stream().filter(c -> c.getName().contains(product)).toArray()[0];
    }


    public String toString() {
        productsContainer.forEach(pc -> System.out.println(pc.getName() + ": " + pc.getPrice() + " warranty: " + pc.getWarranty()));
        return null;
    }

    public int getFullPrice() {
        int price = 0;
        for (ProductPage page: productsContainer) {
            price += page.getPrice();
        }
        return price;

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
