package com.demoqa.tests.elementspagetests;

import com.demoqa.pageobjects.elementspage.ElementsPage;
import com.demoqa.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ElementsPageTests extends BaseTest {
    private ElementsPage elementsPage;

    @BeforeMethod
    public void goToElementsPage() {
        elementsPage = new ElementsPage(driver);
        elementsPage.visit();
        confirmPageLoadedUsingTitle("div", "Please select an item from left to start practice.");
//        Assert.assertTrue(isDisplayed(By.xpath("//div[contains(text(), 'Please select an item from left to start practice.')]")));
    }

    @Parameters({"selection", "itemSize", "items", "initiallySelected"})
    @Test
    public void sideBarTest(String selection, int itemSize, String itemsStr, String initiallySelected) {
        List<String> actualItems = elementsPage.confirmElementsList(selection, initiallySelected);
        Assert.assertEquals(actualItems.size(), itemSize, "Item size does not match");

        // Convert comma-separated string to list
        List<String> expectedItems = Arrays.asList(itemsStr.split(",\\s*"));

        // Check that both lists have the same number of elements
        Assert.assertEquals(expectedItems.size(), actualItems.size(), "Expected and actual lists have different sizes");

        // Compare each item
        for (int i = 0; i < actualItems.size(); i++) {
            String actual = actualItems.get(i);
            String expected = expectedItems.get(i);
            Assert.assertEquals(actual, expected, "Mismatch at index " + i);
        }
    }

}
