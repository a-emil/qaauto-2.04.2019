package page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class ResetPasswordPage extends BasePage {

    @FindBy(xpath = "//input[@id = 'username']")
    private WebElement userNameField;

    @FindBy(xpath = "//form[@id = 'reset-password-form']")
    private WebElement resetPasswordForm;

    @FindBy(xpath = "//button[@id = 'reset-password-submit-button']")
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

        String messageSubject = "here's the link to reset your password";
        String messageTo = userName;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        resetPasswordSubmit.click();

        String htmlBody = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        //System.out.println("Content: " + htmlBody);

        getLink(htmlBody);

        return new CheckEmailPage(driver);
    }

    public void getLink(String htmlBody){
        Document alinks = Jsoup.parse(htmlBody);
        Elements links = alinks.select("a[href]");

        System.out.println("Link: " + links);
    }

}