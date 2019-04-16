import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {


    public WebDriver driver;
    public static String projectUrl = "https://www.linkedin.com";
    public static String userEmail = "engineertest70@gmail.com";
    public static String userPassword = "Test111)";

    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/emil/IdeaProjects/chromedriver");

        driver = new ChromeDriver();
        driver.get(projectUrl);

        WebElement userEmailLogin = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordLinkedin = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement submitToLinkedin = driver.findElement(By.xpath("//input[@id='login-submit']"));

        // successfulPageOpenTest
        //Assert.assertEquals(driver.getTitle(), "LinkedIn: Войти или зарегистрироваться ");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");

        //successfulLoginTest
        userEmailLogin.sendKeys(userEmail);
        userPasswordLinkedin.sendKeys(userPassword);
        submitToLinkedin.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        Assert.assertTrue(profileMenuItem.isDisplayed(),
                "Home page is displayed");


        profileMenuItem.click();
        WebElement userProfileName = driver.findElement(By.xpath("//ul[@id='nav-settings__dropdown-options']//h3"));
        Assert.assertEquals(userProfileName.getText(), "Emilio Carmello", "Wrong profile user name displayed");

        driver.quit();
    }

    @Test
    public void negativeLoginTest(){
        
    }
}