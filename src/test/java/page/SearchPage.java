package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{
    private WebElement searchResultContainer;
    private List<WebElement> searchResultItems;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        searchResultItems = driver.findElements(By.xpath("//li[contains(@class, 'search-result search-result__occluded-item')]"));
        searchResultContainer = driver.findElement(By.xpath("//div[@class='search-results-container']"));
    }

    public int getSearchResultsNumber(){
        return searchResultItems.size();
    }

    public void printResult(){
        for (WebElement searchResultItem : searchResultItems) {
            System.out.println("\n============\n" +  searchResultItem.getText());
        }
    }

    public boolean isPageLoaded(){
        return searchResultContainer.isDisplayed();
    }

    public List<String> getSearchResultsText() {
        List <String> searchResultList = new ArrayList<String>();

        for (WebElement searchResultItem : searchResultItems) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultItem);
            String searchResultText = searchResultItem.getText();
            searchResultList.add(searchResultText);
        }
        return searchResultList;
    }
}