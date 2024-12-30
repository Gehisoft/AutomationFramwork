package testclasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import utilities.DBconnection;
import utilities.LoadProperties;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestBase {


    WebDriver driver;

    @Test(testName = "Default browser opening", priority = 1)
    public void OpenBrowser() throws IOException, SQLException, ClassNotFoundException {


        DBconnection connectionDB = new DBconnection();
        ResultSet res =  connectionDB.getResultSetForQuery("SELECT * \n" +
                "FROM CI_APT_APPOITMENTS caa where rownum < 5");

        while (res.next()){

            String ap_id = res.getString("ID");

        }

        LoadProperties loadProperties = new LoadProperties();

        String envvalue = loadProperties.getTestProperties("env");
        String url = loadProperties.getTestProperties(envvalue + "uri");
        String browsername = loadProperties.getTestProperties("browser");

        if (browsername.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().driverVersion("131.0.6778.205").setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);


        } else if (browsername.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(url);

        }


    }

}
