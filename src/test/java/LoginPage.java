import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LoginPage {

    private WebDriver driver;
    private WebElement userEmailLogin;
    private WebElement userPasswordLinkedin;
    private WebElement submitToLinkedin;
    private WebElement signUpForm;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        userEmailLogin = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordLinkedin = driver.findElement(By.xpath("//input[@id='login-password']"));
        submitToLinkedin = driver.findElement(By.xpath("//input[@id='login-submit']"));
        signUpForm = driver.findElement(By.xpath("//form[@id='regForm']"));
    }

    public HomePage login(String userEmail, String userPassword) {
        userEmailLogin.sendKeys(userEmail);
        userPasswordLinkedin.sendKeys(userPassword);
        submitToLinkedin.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new HomePage(driver);
    }

    public LoginPage loginToLogin(String userEmail, String userPassword) {
        userEmailLogin.sendKeys(userEmail);
        userPasswordLinkedin.sendKeys(userPassword);
        submitToLinkedin.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LoginPage(driver);
    }

    public LoginSubmitPage loginToLoginSubmit(String userEmail, String userPassword) {
        userEmailLogin.sendKeys(userEmail);
        userPasswordLinkedin.sendKeys(userPassword);
        submitToLinkedin.click();
        return new LoginSubmitPage(driver);
    }

    public boolean isLoginPageDisplayed() {
        return signUpForm.isDisplayed();
    }
}