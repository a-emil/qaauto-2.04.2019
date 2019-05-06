import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
                {"engineertest70@gmail.com", "Test111)", "HR"}
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

    @AfterMethod
    public void afterMethod() {
        //driver.quit();
    }

    @Test(dataProvider = "validDataProvider")
    public void SearchResultTest(String userEmail, String userPassword, String searchTerm){
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");

        HomePage homePage = loginPage.login(userEmail, userPassword); // что за строка
        Assert.assertTrue(homePage.isHomePageLoaded(), "Home Page is not loaded");

        SearchPage searchPage = homePage.searchRequest(searchTerm);

        Assert.assertTrue(searchPage.isSearchPageLoaded(), "Search page is not displayed");


        Assert.assertEquals(searchPage.getSearchResultsNumber(), 10, "Incorrect number of search results");
        Assert.assertTrue(searchPage.getSearchResultText(searchTerm), "Not all search results have 'HR' text");
    }
}