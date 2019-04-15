import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {


    public WebDriver driver;
    public static String projectUrl = "https://www.linkedin.com";
    public static String userEmail = "engineertest70@gmail.com";
    public static String userPassword = "Test111)";
    public static String userWrongPassword = "Test222)";
    public static String welcomeMSG = "Emilio Carmello";
    //public static String errorMSG = "Hmm, that's not the right password. Please try again or request a new one.s";
    public static String errorMSG = "Это неверный пароль. Повторите попытку или измените пароль.";
    

/*    @BeforeTest
    public void openProjectUrl(){}
*/


    @Test
    public void successfulLoginTest(){
        //System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(projectUrl);

        WebElement loginToLinkedin = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement passwordToLinkedin = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement submitToLinkedin = driver.findElement(By.xpath("//input[@id='login-submit']"));

        // successfulPageOpenTest
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Войти или зарегистрироваться ");

        //failedLoginTest
        loginToLinkedin.sendKeys(userEmail);
        passwordToLinkedin.sendKeys(userWrongPassword);
        submitToLinkedin.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        Assert.assertEquals(errorMessage.getText(), errorMSG);

        //successfulLoginTest
        WebElement passwordError = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement reSubmit = driver.findElement(By.xpath("//div/button"));

        passwordError.sendKeys(userPassword);
        reSubmit.click();

        WebElement welcomeMessage = driver.findElement(By.xpath("//a[@data-control-name='identity_welcome_message']/span"));
        Assert.assertEquals(welcomeMessage.getText(), welcomeMSG);

        driver.quit();
    }

/*  @AfterTest
        public void endTest(){
            driver.quit();
        }
*/
}