package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetNewPasswordPage extends BasePage {

    @FindBy(xpath = "//form[@id = 'confirm-password-reset-form']")
    private WebElement setNewPasswordForm;

    @FindBy(xpath = "//input[@id = 'newPassword']")
    private WebElement newPassword;

    @FindBy(xpath = "//input[@id = 'confirmPassword']")
    private WebElement confirmNewPassword;

    @FindBy(xpath = "//button[@id = 'reset-password-submit-button']")
    private WebElement newPasswordSubmit;

    public SetNewPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return setNewPasswordForm.isDisplayed();
    }

    public SuccessResetPasswordPage setNewPasswordRequest(String newPass) {

        driver.get(resetPasswordLink);
        newPassword.sendKeys(newPass);
        confirmNewPassword.sendKeys(newPass);
        newPasswordSubmit.click();

        return new SuccessResetPasswordPage(driver);
    }

}
