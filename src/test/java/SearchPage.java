import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebElement searchResultPage;
    private List<WebElement> searchResults;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");

        searchResults = driver.findElements(By.xpath("//div[@class='search-result__wrapper']"));
        searchResultPage = driver.findElement(By.xpath("//div[@class='search-results-container']"));
    }

    public int getSearchResultsNumber(){
        return searchResults.size();
    }

    public boolean getSearchResultText(String searchTerm){

        for (WebElement searchResultItem : searchResults) {
           if (searchResultItem.getText().toLowerCase().contains(searchTerm.toLowerCase()))
               return true;
        }
        return false;
    }

    public boolean isSearchPageLoaded(){
        return searchResultPage.isDisplayed();
    }
}