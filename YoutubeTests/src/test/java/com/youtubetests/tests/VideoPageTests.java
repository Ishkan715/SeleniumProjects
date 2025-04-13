package com.youtubetests.tests;

import com.youtubetests.pageobject.HomePage;
import com.youtubetests.pageobject.SearchResults;
import com.youtubetests.pageobject.VideoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VideoPageTests extends BaseTest {

    @Test
    public void confirmCommentsAreShown() {
        HomePage homePage = new HomePage(driver);
        homePage.visit();
        homePage.searchVideos("Selenium Webdriver");
        Assert.assertTrue(homePage.isTrySearchingMessageAvailable());

        SearchResults searchResults = new SearchResults(driver);
        searchResults.clickOnNthVideoInList(generateRandomInt());

        VideoPage videoPage = new VideoPage(driver);
        videoPage.confirmCommentsSectionIsVisible();
    }
}
