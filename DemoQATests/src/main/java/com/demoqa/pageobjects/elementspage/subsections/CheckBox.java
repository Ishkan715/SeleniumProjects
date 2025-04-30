package com.demoqa.pageobjects.elementspage.subsections;

import com.demoqa.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox extends BasePage {
    public CheckBox(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://demoqa.com/checkbox");
    }

    public void selectCheckBox(String selection) {
        driver.findElement(By.cssSelector("label[for='tree-node-" + selection.toLowerCase() + "']")).click();
    }

    public WebElement waitForResultSection() {
        waitForIsDisplayed((By.id("result")));
        WebElement outputSection = waitForElement(By.id("result"));
        return outputSection;
    }

    public List<String> getActualSelected() {
        WebElement resultSection = waitForResultSection();
        List<WebElement> selectedSections = resultSection.findElements(By.className("text-success"));

        List<String> actualSelections = selectedSections.stream().map(WebElement::getText).toList();
        return actualSelections;
    }

    public void extendDropDown(String selection) {
        WebElement selectionElement = driver.findElement(By.cssSelector("label[for='tree-node-" + selection.toLowerCase() + "']"));
        WebElement selectionDropDownButton = selectionElement.findElement(By.xpath("preceding-sibling::button[1]"));
        selectionDropDownButton.click();
    }

}
