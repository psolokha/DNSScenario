import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ScenarioTest {


    @Test
    public void testScenario(){

        WebDriver driver = InitDriver.getInstance();

        MainPage main = new MainPage();
        SearchResultPage searchResult = main.searchItem("playstation");
        ProductPage playstation = searchResult.chooseProduct("PlayStation 4 Slim Black");
        playstation.buyWarranty(2);
        playstation.buyProduct();
        ProductPage detroit = playstation.searchOther("Detroit");
        detroit.buyProduct();

        Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//nav//span[@data-of='totalPrice']")).getText().replace(" ", "")), ProductsContainer.getInstance().getFullPrice());

        ItemCartPage cart = detroit.goToCart();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'radio radio_checked']/label[contains(text(), '2')]")).isDisplayed());

        cart.removeFromCart("Detroit");


        Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//nav//span[@data-of='totalPrice']")).getText().replace(" ", "")), ProductsContainer.getInstance().getFullPrice());

        cart.addAnotherOne("PlayStation");
        cart.addAnotherOne("PlayStation");

        Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//nav//span[@data-of='totalPrice']")).getText().replace(" ", "")), (ProductsContainer.getInstance().getItem("PlayStation")).getPrice() * 3);

        cart.undoRemoved();

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'cart-list__products')]//*[contains(text(), 'Detroit')]")).isDisplayed());


        System.out.println("-----------------------------");
        ProductsContainer.getInstance().printItems();

    }

}
