import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {


    public WebDriver driver;
    public static String projectUrl = "https://www.linkedin.com";
    public static String wrongUserPassword = "Test222)";
    public static String errorMSG = "Hmm, that's not the right password. Please try again or request a new one.s";
    //public static String errorMSG = "Это неверный пароль. Повторите попытку или измените пароль.";


    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);


        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("engineertest70@gmail.com", "Test111)");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProfileMenuItemDisplayed(), "Home page is displayed");
        homePage.clickOnProfileMenuItem();
        Assert.assertEquals(homePage.getUserProfileName(), "Emilio Carmello", "Wrong profile user name displayed");

        driver.quit();
    }

    @Test
    public void negativeLoginTestIncorrect(){
        //System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);

        WebElement userEmailLogin = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordLinkedin = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement submitToLinkedin = driver.findElement(By.xpath("//input[@id='login-submit']"));

       // userEmailLogin.sendKeys(userEmail);
        userPasswordLinkedin.sendKeys(wrongUserPassword);
        submitToLinkedin.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        Assert.assertEquals(errorMessage.getText(), errorMSG, "Error page are not displayed");

        driver.quit();
    }

    @Test
    public void negativeLoginTestEmpty(){
        //System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);

        WebElement userEmailLogin = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordLinkedin = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement submitToLinkedin = driver.findElement(By.xpath("//input[@id='login-submit']"));

      //  userEmailLogin.sendKeys(userEmail);
        userPasswordLinkedin.sendKeys("");
        submitToLinkedin.click();

        // successfulPageOpenTest
        //Assert.assertEquals(driver.getTitle(), "LinkedIn: Войти или зарегистрироваться ");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");

        WebElement signUpForm = driver.findElement(By.xpath("//form[@id='reg-form']"));
        Assert.assertTrue(signUpForm.isDisplayed(),
                "Login page is still displayed");

        driver.quit();

    }
}