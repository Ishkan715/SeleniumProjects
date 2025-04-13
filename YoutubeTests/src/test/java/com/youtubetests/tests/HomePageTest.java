package com.youtubetests.tests;

import com.youtubetests.pageobject.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void navigateToHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.visit();
    }

    @Test
    public void confirmNavTilesAreAvailable() {
        HomePage homePage = new HomePage(driver);
        homePage.visit();
        homePage.confirmAllNavTilesAreAvailable();
    }

    public void openGuideSideNavBar() {
        HomePage homePage = new HomePage(driver);
        homePage.visit();
        homePage.clickGuideButton();
        Assert.assertTrue(driver.findElement(By.id("guide-content")).isDisplayed());
    }
}
