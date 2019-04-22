import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {
    private WebDriver driver;
    private WebElement errorMessage;


    public LoginSubmitPage (WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        errorMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}