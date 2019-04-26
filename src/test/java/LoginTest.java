import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {


    public WebDriver driver;
    public static String projectUrl = "https://www.linkedin.com";

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "engineertest70@gmail.com", "Test111)" },
                { "ENGINEERTEST70@gmail.com", "Test111)" }
        };
    }

    @DataProvider
    public Object[][] inValidDataProvider() {
        return new Object[][]{
                { "engineertest71@gmail.com", "Test111)" },
                { "engineertest70@gmail.com", "Test222)" }
        };
    }

    @DataProvider
    public Object[][] EmptyDataProvider() {
        return new Object[][]{
                { "", "Test111)" },
                { "engineertest70@gmail.com", "" }
        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);


        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isWelcomeCardDisplayed(), "Home page is not displayed");
        Assert.assertEquals(homePage.getUserProfileName(), "Emilio Carmello", "Wrong profile user name displayed");

        driver.quit();
    }

    @Test(dataProvider = "inValidDataProvider")
    public void negativeLoginTestIncorrect(String userEmail, String userPassword){
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);



        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userEmail, userPassword);

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertEquals(loginSubmitPage.getErrorMessage(), "Hmm, that's not the right password. Please try again or request a new one.", "Error page are not displayed");
        //Assert.assertEquals(loginSubmitPage.getErrorMessage(), "Это неверный пароль. Повторите попытку или измените пароль.", "Error page are not displayed");

        driver.quit();
    }

    @Test(dataProvider = "EmptyDataProvider")
    public void negativeLoginTestWithEmptyFields(String userEmail, String userPassword){
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);


        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userEmail, userPassword);

        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");

        driver.quit();
    }
}