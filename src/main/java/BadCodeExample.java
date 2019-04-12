import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String searchTerm = "Selenium";

        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Search results count: " + searchResults.size());

        for (WebElement searchResult : searchResults) {
            if (searchResult.getText().toLowerCase().contains(searchTerm.toLowerCase())){
                System.out.println("\n============= searchTerm '" + searchTerm + "' WAS found ============= \n");
            }
            else
            {
                System.out.println("\n============= searchTerm '" + searchTerm + "' WAS NOT found ============= \n");
            }
            System.out.println(searchResult.getText());
        }
        driver.quit();
    }
}