package page;

import org.openqa.selenium.WebDriver;
import util.GMailService;

public abstract class BasePage {
    protected WebDriver driver;
    protected static String resetPasswordLink;

    public abstract boolean isPageLoaded();

    protected static GMailService gMailService = new GMailService();
}