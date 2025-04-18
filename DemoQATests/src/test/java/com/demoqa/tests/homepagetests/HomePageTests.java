package com.demoqa.tests.homepagetests;

import com.demoqa.pageobjects.homepage.HomePage;
import com.demoqa.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void goToHomePage() {
        homePage = new HomePage(driver);
        homePage.visit();
        Assert.assertTrue(isDisplayed(By.id("app")));
    }

    @Test
    public void navigateToHomepage() {
        WebElement pageApp = driver.findElement(By.id("app"));
        Assert.assertTrue(pageApp.isDisplayed());
    }

    @Test
    public void navigateToElementsPage() {
        homePage.goToPage("Elements");
        Assert.assertEquals(homePage.getCurrentUrl(), "https://demoqa.com/elements");
    }

    @Test
    public void navigateToFormsPage() {
        homePage.goToPage("Forms");
        Assert.assertEquals(homePage.getCurrentUrl(), "https://demoqa.com/forms");
    }

    @Test
    public void navigateToAlertsFrameWindowsPage() {
        homePage.goToPage("Alerts, Frame & Windows");
        Assert.assertEquals(homePage.getCurrentUrl(), "https://demoqa.com/alertsWindows");
    }

    @Test
    public void navigateToWidgetsPage() {
        homePage.goToPage("Widgets");
        Assert.assertEquals(homePage.getCurrentUrl(), "https://demoqa.com/widgets");
    }

    @Test
    public void navigateToInteractionsPage() {
        homePage.goToPage("Interactions");
        Assert.assertEquals(homePage.getCurrentUrl(), "https://demoqa.com/interaction");
    }

    @Test
    public void navigateToBookStoreApplicationsPage() {
        homePage.goToPage("Book Store Application");
        Assert.assertEquals(homePage.getCurrentUrl(), "https://demoqa.com/books");
    }

    @Test
    public void navigateToSeleniumTrainingPage() {
        Assert.assertTrue(isDisplayed(By.className("banner-image")));
        driver.findElement(By.className("banner-image")).click();
        switchToNewTab();
        Assert.assertEquals(homePage.getCurrentUrl(), "https://www.toolsqa.com/selenium-training/");
    }

}
