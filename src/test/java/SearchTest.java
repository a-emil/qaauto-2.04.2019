import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private static String projectUrl = "https://www.linkedin.com";

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"engineertest70@gmail.com", "Test111)"}
        };
    }

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "validDataProvider")
    public void SearchResultTest(String userEmail, String userPassword){
        HomePage homePage = loginPage.login(userEmail, userPassword);
        homePage.searchRequest("HR");
    }
}
