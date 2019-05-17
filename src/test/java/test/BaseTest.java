package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;
    private static String projectUrl = "https://www.linkedin.com";


    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}