import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class ScenarioTest {


    @Test
    public void testScenario(){

        MainPage main = new MainPage();
        SearchResultPage searchResult = main.searchItem("playstation");
        ProductPage playstation = searchResult.chooseProduct("PlayStation 4 Slim Black");
        playstation.buyWarranty(2);
        playstation.buyProduct();
        ProductPage detroit = playstation.searchOther("Detroit");
        detroit.buyProduct();
        ItemCartPage cart = detroit.goToCart();
        cart.removeFromCart("Detroit");
        cart.addAnotherOne("PlayStation");
        cart.addAnotherOne("PlayStation");
        cart.undoRemoved();

    }

}
