package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    public String  getTestProperties(String propertyname) throws IOException {

        Properties properties = new Properties();
        FileReader fr = new FileReader("src/main/resources/config.properties");
        properties.load(fr);
        return properties.getProperty(propertyname);
    }

}
