import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private WebElement profileMenuItem;
    private WebElement userProfileName;
    private WebElement profileWelcomeCard;
    private WebElement searchRequestField;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        profileWelcomeCard = driver.findElement(By.xpath("//a[@data-control-name='identity_welcome_message']"));
        searchRequestField = driver.findElement(By.xpath("//div[@class='nav-search-typeahead']//input"));
    }

    public boolean isProfileMenuItemDisplayed() {
        return profileMenuItem.isDisplayed();
    }

    public boolean isHomePageLoaded() {
        return profileWelcomeCard.isDisplayed();
    }

    public String getUserProfileName() {
        userProfileName = driver.findElement(By.xpath("//ul[@id='nav-settings__dropdown-options']//h3"));
        return userProfileName.getText();
    }

    public void searchRequest(String searchTerm){
        searchRequestField.sendKeys(searchTerm);
        searchRequestField.sendKeys(Keys.ENTER);
    }
}