import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

class ItemCartPage extends AbstractPage{

    void removeFromCart(String item) {
        driver.findElement(By.xpath("//a[contains(text(), '"+ item +"')]/ancestor::div[3]//button[@class = 'remove-button']")).click();
        ProductsContainer.getInstance().removeFromContainer(item);
    }

    void addAnotherOne(String item) {
        driver.findElement(By.xpath("//a[contains(text(), '" + item + "')]/ancestor::div[3]//i[@class = 'count-buttons__icon-plus']")).click();
        new WebDriverWait(driver, 3);
        ProductsContainer pc = ProductsContainer.getInstance();
        pc.addToContainer(pc.getItem(item));
    }

    void undoRemoved() {
        driver.findElement(By.xpath("//span[text() = 'Вернуть удалённый товар']")).click();
        ProductsContainer.getInstance().addAllRemovedItems();
    }

}
