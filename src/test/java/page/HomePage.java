package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class HomePage extends BasePage{
    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileMenuItem;

    @FindBy(xpath = "//ul[@id='nav-settings__dropdown-options']//h3")
    private WebElement userProfileName;

    @FindBy(xpath = "//a[@data-control-name='identity_welcome_message']")
    private WebElement profileWelcomeCard;

    @FindBy(xpath = "//form[@id='extended-nav-search']//input")
    private WebElement searchRequestField;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, HomePage.class);
    }

    public boolean isProfileMenuItemDisplayed() {
        return profileMenuItem.isDisplayed();
    }

    public void ClickProfileMenuItem() {
        profileMenuItem.click();
    }

    public boolean isPageLoaded() {
        return profileWelcomeCard.isDisplayed();
    }

    public String getUserProfileName() {
        return userProfileName.getText();
    }

    public SearchPage searchRequest(String searchTerm){
        searchRequestField.sendKeys(searchTerm);
        searchRequestField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchPage(driver);
    }
}