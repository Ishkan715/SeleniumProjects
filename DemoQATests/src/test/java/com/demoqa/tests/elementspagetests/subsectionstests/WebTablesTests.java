package com.demoqa.tests.elementspagetests.subsectionstests;

import com.demoqa.pageobjects.elementspage.subsections.WebTables;
import com.demoqa.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTablesTests extends BaseTest {
    private WebTables webTables;

    @BeforeMethod
    public void goToCheckBox() {
        webTables = new WebTables(driver);
        webTables.visit();
        Assert.assertTrue(isDisplayed(By.xpath("//h1[contains(text(), 'Web Tables')]")));
    }

    @Test
    public void addNewEntry() {
        int initialNumberOfEntries = webTables.numberOfEntriesInTable();
        webTables.addNewEntry("Ishkan", "Oganesyan", "test@test.com", 35, 85000, "QA Engineer");
        int currentNumberOfEntries = webTables.numberOfEntriesInTable();
        Assert.assertTrue(initialNumberOfEntries < currentNumberOfEntries);
    }

    @Test
    public void editExistingEntry() {
        int initialNumberOfEntries = webTables.numberOfEntriesInTable();
        webTables.editEntry(1, "Ishkan", "Oganesyan", "test@test.com", 35, 85000, "QA Engineer");
        int currentNumberOfEntries = webTables.numberOfEntriesInTable();
        Assert.assertTrue(initialNumberOfEntries == currentNumberOfEntries);
    }

    @Test
    public void deleteExistingEntry() {
        int initialNumberOfEntries = webTables.numberOfEntriesInTable();
        webTables.deleteEntry(2);
        int currentNumberOfEntries = webTables.numberOfEntriesInTable();
        Assert.assertTrue(initialNumberOfEntries > currentNumberOfEntries);
    }

    @Parameters({"searchBy"})
    @Test
    public void searchExistingEntry(String searchBy) {
        webTables.searchEntry(searchBy);
        int currentNumberOfEntries = webTables.numberOfEntriesInTable();
        Assert.assertTrue(currentNumberOfEntries == 1);

        WebElement rowElement = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@role='row']"));
        Assert.assertTrue(rowElement.getText().contains(searchBy));
    }
}
