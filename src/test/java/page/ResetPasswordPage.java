package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage {

    @FindBy(xpath = "//input[@id = 'username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id = 'reset-password-form']")
    private WebElement resetPasswordForm;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmit;


    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resetPasswordForm.isDisplayed();
    }

    public CheckEmailPage ResetPasswordRequest(String userName) {
        userNameField.sendKeys(userName);
        resetPasswordSubmit.click();
        return new CheckEmailPage(driver);
    }


}