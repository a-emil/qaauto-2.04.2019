package page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public String resetPasswordLink;

    public abstract boolean isPageLoaded();

}