import org.junit.Test;


public class ScenarioTest {


    @Test
    public void testScenario(){
        MainPage main = new MainPage();
        SearchResultPage searchResult = main.searchItem("playstation");
        ItemCartPage cart = main.goToCart();
        //searchResult.addProductToCart("PlayStation 4 Slim Black");
        System.out.println("done!");
    }

}
