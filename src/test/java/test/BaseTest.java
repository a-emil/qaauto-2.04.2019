package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LoginPage;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;
    private String projectUrl;


    @Parameters({"browserName", "localization"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName, @Optional("EN") String localization) throws Exception {
        if(browserName.toLowerCase().equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.toLowerCase().equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            throw new Exception("Unsupported browser name");
        }

        if (localization.equals("UA")){
            driver.get("https://ua.linkedin.com");
        }
        else if (localization.equals("DE")) {
            driver.get("https://de.linkedin.com");
        }
        else {
            driver.get("https://en.linkedin.com");
        }

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        //driver.quit();
    }
}