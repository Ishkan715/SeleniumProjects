package com.youtubetests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By searchBarLocator = By.xpath("//div[@class='ytSearchboxComponentInputBox']//input");
    private By trySearchingMessageLocator = By.id("dismissible");
    private By homeNavTileLocator = By.xpath("//ytd-mini-guide-entry-renderer[@aria-label='Home']");
    private By shorstNavTileLocator = By.xpath("//ytd-mini-guide-entry-renderer[@aria-label='Shorts']");
    private By subscriptionsNavTileLocator = By.xpath("//ytd-mini-guide-entry-renderer[@aria-label='Subscriptions']");
    private By youNavTileLocator = By.xpath("//ytd-mini-guide-entry-renderer[@aria-label='You']");
    private By historyNavTileLocator = By.xpath("//ytd-mini-guide-entry-renderer[@aria-label='History']");
    private By guideButtonLocator = By.xpath("//yt-icon-button[@id='guide-button']//button[@aria-label='Guide']");


    public HomePage(WebDriver driver) {
        super(driver); // calls constructor of BasePage
    }

    public void visit() {
        super.visit("https://youtube.com/");
    }

    public void searchVideos(String video) {
        WebElement searchBar = waitForElement(searchBarLocator);
        searchBar.sendKeys(video);
        searchBar.sendKeys(Keys.RETURN);
    }

    public boolean isTrySearchingMessageAvailable () {
        return waitForIsHidden(trySearchingMessageLocator);
    }

    public void confirmAllNavTilesAreAvailable() {
        waitForIsDisplayed(homeNavTileLocator);
        waitForIsDisplayed(shorstNavTileLocator);
        waitForIsDisplayed(subscriptionsNavTileLocator);
        waitForIsDisplayed(youNavTileLocator);
        waitForIsDisplayed(historyNavTileLocator);
    }

    public void clickGuideButton() {
        waitForElement(guideButtonLocator).click();
    }

}
