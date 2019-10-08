import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ScenarioProperties {

    private Properties properties = new Properties();

    private static ScenarioProperties instance;

    private ScenarioProperties(){
        try {
            properties.load(new FileInputStream(new File("src/test/resources/env.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ENV property");
    }

    public static ScenarioProperties getInstance() {
        return instance == null ? new ScenarioProperties() : instance;
    }

    public String getProperty(String... key) {
        return key.length > 1 ? properties.getProperty(key[0],key[1]) : properties.getProperty(key[0]);
    }

}
