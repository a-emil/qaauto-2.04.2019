package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessResetPasswordPage extends BasePage {

    @FindBy(xpath = "//form[@id = 'reset-password-confirm-form']")
    private WebElement confirmResetPasswordPage;

    @FindBy(xpath = "//h1[@class = 'content__header']")
    private WebElement headerText;

    @FindBy(xpath = "//button[@id = 'reset-password-submit-button']")
    private WebElement goToHomePageButton;

    public SuccessResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return confirmResetPasswordPage.isDisplayed();
    }


    public String getHeaderText() {
        return headerText.getText();
    }

    public boolean isGoToHomePageButton() {
        return goToHomePageButton.isDisplayed();
    }
}
