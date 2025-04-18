package com.demoqa.pageobjects.homepage;

import com.demoqa.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By elementsCardLocator = By.xpath("//div[h5[text()='Elements']]");
    private By formsCardLocator = By.xpath("");
    private By alertsCardLocator = By.xpath("");
    private By widgetsCardLocator = By.xpath("");
    private By interactionsCardLocator = By.xpath("");
    private By bookStoreApplicationCardLocator = By.xpath("");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://demoqa.com/");
    }

    public void goToPage(String page) {
        driver.findElement(By.xpath("//div[h5[normalize-space(text())='" + page + "']]")).click();
    }

}
