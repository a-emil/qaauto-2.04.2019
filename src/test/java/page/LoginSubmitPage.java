package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSubmitPage extends BasePage {

    @FindBy(xpath = "//div[@id='error-for-password']")
    private WebElement UserEmailValidationMessage;

    @FindBy(xpath = "//div[@id='error-for-username']")
    private WebElement UserPasswordValidationMessage;

    @FindBy(xpath = "//form[@class='login__form']")
    private WebElement signInForm;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return signInForm.isDisplayed();
    }

    public String getUserEmailValidationMessage() {
        return UserEmailValidationMessage.getText();
    }

    public String getUserPasswordValidationMessage() {
        return UserPasswordValidationMessage.getText();
    }
}