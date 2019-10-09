import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

class ItemCartPage extends AbstractPage{

    void removeFromCart(String item) {
        driver.findElement(By.xpath("//a[contains(text(), '"+ item +"')]/ancestor::div[3]//button[@class = 'remove-button']")).click();
        ProductsContainer.getInstance().removeFromContainer(item);
        new Actions(driver).pause(500).build().perform();
    }

    void addAnotherOne(String item) {
        WebElement plus = driver.findElement(By.xpath("//a[contains(text(), '" + item + "')]/ancestor::div[3]//i[@class = 'count-buttons__icon-plus']"));
        waitElement(plus);
        new Actions(driver).moveToElement(plus).click().pause(1500).build().perform();
        ProductsContainer pc = ProductsContainer.getInstance();
        pc.addToContainer(pc.getItem(item));
        new Actions(driver).pause(500).build().perform();
    }

    void undoRemoved() {
        driver.findElement(By.xpath("//a[@class = 'restore-last-removed']/span")).click();
        ProductsContainer.getInstance().addAllRemovedItems();
    }

}
