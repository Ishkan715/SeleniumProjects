package com.demoqa.pageobjects.homepage;

import com.demoqa.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

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
