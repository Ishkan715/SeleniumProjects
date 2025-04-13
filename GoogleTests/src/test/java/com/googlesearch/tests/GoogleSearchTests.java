package com.googlesearch.tests;

import com.googlesearch.pageobjects.GoogleSearch;
import org.testng.annotations.Test;

public class GoogleSearchTests extends BaseTest {

    @Test
    public void searchNewTopic() {
        GoogleSearch googleSearch = new GoogleSearch(driver);
        googleSearch.visit();
        googleSearch.searchNewTopic("Selenium Webdriver");
    }
}
