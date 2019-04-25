import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private WebElement profileMenuItem;
    private WebElement userProfileName;
    private WebElement profileWelcomeCard;

    public HomePage(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        profileWelcomeCard = driver.findElement(By.xpath("//div[@class='feed-identity-module__actor-meta profile-rail-card__actor-meta break-words']"));
    }

    public boolean isProfileMenuItemDisplayed(){
        return profileMenuItem.isDisplayed();
    }

    public void clickOnProfileMenuItem(){
        profileMenuItem.click();
    }

    public String getUserProfileName(){
        userProfileName = driver.findElement(By.xpath("//ul[@id='nav-settings__dropdown-options']//h3"));
        return userProfileName.getText();
    }

    public boolean isHomePageLoaded(){
        return userProfileName.isDisplayed();
    }
}
