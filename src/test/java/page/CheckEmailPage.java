package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckEmailPage extends BasePage {

    @FindBy(xpath = "//form[@id = 'sendemail-form']")
    private WebElement sendEmailForm;

    public CheckEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return sendEmailForm.isDisplayed();
    }

}
