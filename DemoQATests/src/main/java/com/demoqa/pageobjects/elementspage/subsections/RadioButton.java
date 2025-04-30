package com.demoqa.pageobjects.elementspage.subsections;

import com.demoqa.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton extends BasePage {
    public RadioButton(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://demoqa.com/radio-button");
    }

    public void selectOption(String option) {
        driver.findElement(By.cssSelector("label[for='" + option.toLowerCase() + "Radio']")).click();
    }

    public WebElement waitForSectedOptionSection() {
        waitForIsDisplayed((By.className("mt-3")));
        WebElement selectedOption = waitForElement(By.className("mt-3"));
        WebElement selection = selectedOption.findElement(By.className("text-success"));
        return selection;
    }
}
