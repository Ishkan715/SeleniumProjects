package com.demoqa.pageobjects.elementspage;

import com.demoqa.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ElementsPage extends BasePage {
    private By elementsNavBarLocator = By.xpath("//div[@class='element-group']//div[contains(text(), 'Elements')]");
    private By formsNavBarLocator = By.xpath("");
    private By alertsNavBarLocator = By.xpath("");
    private By widgetsNavBarLocator = By.xpath("");
    private By interactionsNavBarLocator = By.xpath("");
    private By bookStoreApplicationNavBarLocator = By.xpath("");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://demoqa.com/elements");
    }

    public void clickSideBarSelection(String selection, String initiallySelected) {
        WebElement selectionElement = driver.findElement(By.xpath("//div[@class='element-group']//div[contains(text(), '" + selection + "')]"));

        if (selection.equals(initiallySelected)) {
            // Do Nothing
        } else {
            selectionElement.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("show")));
        }
    }

    public List<String> confirmElementsList(String selection, String initiallySelected) {
        clickSideBarSelection(selection, initiallySelected);
        List<WebElement> items = driver.findElements(By.xpath(
                "//div[@class='element-group'][.//div[@class='header-text' and contains(., '" + selection + "')]]//ul[@class='menu-list']/li"
        ));

        List<String> itemTexts = new ArrayList<>();

        if (items.isEmpty()) {
            System.out.println("No list items found for: " + selection);
        } else {
            for (WebElement item : items) {
                itemTexts.add(item.getText());
            }
        }

        return itemTexts;
    }

}
