package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailLogin;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordLinkedin;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement submitToLinkedin;

    @FindBy(xpath = "//form[@id='regForm']")
    private WebElement signUpForm;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement linkForgotPassword;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public <GenericPage> GenericPage login(String userEmail, String userPassword) {
        userEmailLogin.sendKeys(userEmail);
        userPasswordLinkedin.sendKeys(userPassword);
        submitToLinkedin.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver.getCurrentUrl().contains("/feed")) {
            return (GenericPage) new HomePage(driver);
        } else if (driver.getCurrentUrl().contains("/login-submit")) {
            return (GenericPage) new LoginSubmitPage(driver);
        } else {
            return (GenericPage) new LoginPage(driver);
        }
    }


    public ResetPasswordPage clickForgotPassord() {
        linkForgotPassword.click();
        return new ResetPasswordPage(driver);
    }

    public boolean isPageLoaded() {
        return signUpForm.isDisplayed();
    }
}