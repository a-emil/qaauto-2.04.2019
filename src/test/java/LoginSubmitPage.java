import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {
    private WebDriver driver;
    private WebElement errorMessage;
    private WebElement signInForm;

    public LoginSubmitPage (WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        errorMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        signInForm = driver.findElement(By.xpath("//form[@class='login__form']"));
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public boolean isLoginSubmitPageLoaded(){
        return signInForm.isDisplayed();
    }
}