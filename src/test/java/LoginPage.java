import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static java.lang.Thread.sleep;

public class LoginPage {
    WebDriver driver;

    WebElement userEmailLogin;
    WebElement userPasswordLinkedin;
    WebElement submitToLinkedin;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    public void initElements(){
        userEmailLogin = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordLinkedin = driver.findElement(By.xpath("//input[@id='login-password']"));
        submitToLinkedin = driver.findElement(By.xpath("//input[@id='login-submit']"));
    }

    public void login(String userEmail, String userPassword) {
        userEmailLogin.sendKeys(userEmail);
        userPasswordLinkedin.sendKeys(userPassword);
        submitToLinkedin.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}