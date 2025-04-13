package com.googlesearch.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch extends BasePage {
    private By searchBarLocator = By.xpath("//textarea[@aria-label='Search']");

    public GoogleSearch(WebDriver driver) {
        super(driver); // calls constructor of BasePage
    }

    public void visit() {
        super.visit("https://google.com/");
    }

    public void searchNewTopic(String topic) {
        WebElement searchBar = waitForElement(searchBarLocator);
        searchBar.sendKeys(topic);
        searchBar.sendKeys(Keys.RETURN);
    }
}
