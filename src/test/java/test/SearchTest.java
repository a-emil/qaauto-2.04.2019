package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;
import java.util.List;

public class SearchTest extends BaseTest{

    @Test
    public void BasicSearchTest(){
        String userEmail = "engineertest70@gmail.com";
        String userPassword = "Test111)";
        String searchTerm = "HR";
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not displayed");

        HomePage homePage = loginPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");

        SearchPage searchPage = homePage.searchRequest(searchTerm);

        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not displayed");

        Assert.assertEquals(searchPage.getSearchResultsNumber(), 10, "Incorrect number of search results");

        List<String> searchResultList = searchPage.getSearchResultsText();

        for(String searchResult: searchResultList){
            Assert.assertTrue(searchResult.contains(searchTerm), "searchTerm: " + searchTerm + " not found in \n" + searchResult);
        }
    }
}