import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class InitDriver {

    private static WebDriver driver;
    private static InitDriver instance;

    private InitDriver() {
        ScenarioProperties properties = ScenarioProperties.getInstance();
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("timeout.global")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(properties.getProperty("timeout.pageLoad")), TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }

    static WebDriver getInstance(){
        if (instance == null) instance = new InitDriver();
        return driver;
    }

}
