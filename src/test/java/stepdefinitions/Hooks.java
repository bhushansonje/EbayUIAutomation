package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {
    @Before
    public void setUp() throws IOException {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();

        // Load properties file
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config/web.properties");
        properties.load(fis);

        String baseUrl = properties.getProperty("base.url", "https://www.ebay.com");
        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
