package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class CheckEmailPage extends BasePage {

    @FindBy(xpath = "//form[@id = 'sendemail-form']")
    private WebElement sendEmailForm;

    @FindBy(xpath = "//input[@type = 'email']")
    private WebElement userEmail;

    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement userPassword;

    @FindBy(xpath = "//div[@id = 'passwordNext']")
    private WebElement gmailSubmit;

    @FindBy(xpath = "//table//div[@class = 'yW']")
    private WebElement newEmail;

    @FindBy(xpath = "//table//tr[4]//p/a")
    private WebElement newResetPasswordLink;



    public CheckEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return sendEmailForm.isDisplayed();
    }

    public SetNewPasswordPage goToGmailForLink(){
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        userEmail.sendKeys("engineertestforreset70@gmail.com");
        userEmail.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userPassword.sendKeys("Tester13)");
        gmailSubmit.click();
        newEmail.click();
        newResetPasswordLink.click();
        return new SetNewPasswordPage(driver);
    }

}
