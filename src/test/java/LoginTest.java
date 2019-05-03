import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
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

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"engineertest70@gmail.com", "Test111)"},
                //{"ENGINEERTEST70@gmail.com", "Test111)"}
        };
    }

    @DataProvider
    public Object[][] inValidDataProvider() {
        return new Object[][]{
                {"engineertest70@gmail.com", "Test222)", "", "Hmm, that's not the right password. Please try again or request a new one."},
                {"engineertest71@gmail.com", "Test111)", "Hmm, we don't recognize that email. Please try again.", ""}
        };
    }

    @DataProvider
    public Object[][] EmptyDataProvider() {
        return new Object[][]{
                {"", "Test111)"},
                {"engineertest70@gmail.com", ""}
        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isHomePageLoaded(), "Home page is not displayed");
        Assert.assertEquals(homePage.getUserProfileName(), "Emilio Carmello", "Wrong profile user name displayed");
    }

    @Test(dataProvider = "inValidDataProvider")
    public void negativeLoginTestWithInvslidData(String userEmail,
                                                 String userPassword,
                                                 String userPasswordValidationMessage,
                                                 String userEmailValidationMessage) {
        LoginSubmitPage loginSubmitPage = loginPage.loginToLoginSubmit(userEmail, userPassword);

        Assert.assertTrue(loginSubmitPage.isLoginSubmitPageLoaded(), "Login page is not loaded");
        Assert.assertEquals(loginSubmitPage.getUserEmailValidationMessage(), userEmailValidationMessage, "Wrong validation message on user email");
        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationMessage(), userPasswordValidationMessage, "Wrong validation message on user password");
    }

    @Test(dataProvider = "EmptyDataProvider")
    public void negativeLoginTestWithEmptyFields(String userEmail, String userPassword) {
        loginPage.loginToLogin(userEmail, userPassword);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
    }
}