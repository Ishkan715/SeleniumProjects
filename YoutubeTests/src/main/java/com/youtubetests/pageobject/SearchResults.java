package com.youtubetests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResults extends BasePage {
    private By videoTileLocator = By.tagName("ytd-thumbnail");

    public SearchResults(WebDriver driver) {
        super(driver); // calls constructor of BasePage
    }

    public List<WebElement> getListOfVideos() {
        return driver.findElements(videoTileLocator);
    }

    public void clickOnNthVideoInList(int nthVideo) {
        List<WebElement> videos = getListOfVideos();
        if (nthVideo >= 0 && nthVideo < videos.size()) {
            videos.get(nthVideo).click();
        }
    }
}
