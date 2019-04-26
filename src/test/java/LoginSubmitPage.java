import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {
    private WebDriver driver;
    private WebElement UserEmailValidationMessage;
    private WebElement UserPasswordValidationMessage;
    private WebElement signInForm;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        UserEmailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        UserPasswordValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        signInForm = driver.findElement(By.xpath("//form[@class='login__form']"));
    }


    public boolean isLoginSubmitPageLoaded() {
        return signInForm.isDisplayed();
    }

    public String getUserEmailValidationMessage() {
        return UserEmailValidationMessage.getText();
    }

    public String getUserPasswordValidationMessage() {
        return UserPasswordValidationMessage.getText();
    }
}