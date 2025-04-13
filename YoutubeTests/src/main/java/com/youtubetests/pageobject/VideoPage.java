package com.youtubetests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VideoPage extends BasePage {
    private By commentsSectionLocator = By.id("comments");

    public VideoPage(WebDriver driver) {
        super(driver); // calls constructor of BasePage
    }

    public void confirmCommentsSectionIsVisible() {
//        WebElement commentsSection = waitForElement(commentsSectionLocator);
        Assert.assertTrue(waitForIsDisplayed(commentsSectionLocator));
    }
}
