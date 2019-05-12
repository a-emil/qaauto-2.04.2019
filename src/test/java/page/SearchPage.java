package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, 'search-result search-result__occluded-item')]")
    private WebElement searchResultContainer;

    @FindBy(xpath = "//div[@class='search-results-container']")
    private List<WebElement> searchResultItems;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getSearchResultsNumber() {
        return searchResultItems.size();
    }

    public boolean isPageLoaded() {
        return searchResultContainer.isDisplayed();
    }

    public List<String> getSearchResultsText() {
        List<String> searchResultList = new ArrayList<String>();

        for (WebElement searchResultItem : searchResultItems) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultItem);
            String searchResultText = searchResultItem.getText();
            searchResultList.add(searchResultText);
        }
        return searchResultList;
    }
}