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

    public SetNewPasswordPage ResetPasswordRequest(String userName) {
        userNameField.sendKeys(userName);

        String messageSubject = "here's the link to reset your password";
        String messageTo = userName;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        resetPasswordSubmit.click();

        String htmlBody = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);

        getResetPasswordLink(htmlBody);

        return new SetNewPasswordPage(driver);
    }

    public String getResetPasswordLink(String htmlBody){
        String resetPasswotdLink;
        Document htmlDocument = Jsoup.parse(htmlBody);
        Elements listOflinks = htmlDocument.select("a[abs:href]");

        for( Element link : listOflinks) {
            if (link.text().equals("Reset my password")) {
                resetPasswotdLink = link.attr("abs:href").toString();
                return resetPasswotdLink;
            }
        }
        return "";
    }

}