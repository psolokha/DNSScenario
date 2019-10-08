import org.openqa.selenium.Keys;

public class MainPage extends AbstractPage {

    public SearchResultPage searchItem(String item) {
        waitElement(inputSearch);
        inputSearch.click();
        inputSearch.sendKeys(item);
        inputSearch.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }





}
