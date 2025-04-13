package com.youtubetests.tests;

import com.youtubetests.pageobject.HomePage;
import com.youtubetests.pageobject.SearchResults;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTests extends BaseTest {

    @Test
    public void clickOnAVideo() {
        HomePage homePage = new HomePage(driver);
        homePage.visit();
        homePage.searchVideos("Selenium Webdriver");
        Assert.assertTrue(homePage.isTrySearchingMessageAvailable());

        SearchResults searchResults = new SearchResults(driver);
        searchResults.clickOnNthVideoInList(generateRandomInt());
    }
}
