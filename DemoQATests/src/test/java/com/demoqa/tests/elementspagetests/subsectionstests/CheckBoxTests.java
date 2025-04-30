package com.demoqa.tests.elementspagetests.subsectionstests;

import com.demoqa.pageobjects.elementspage.subsections.CheckBox;
import com.demoqa.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CheckBoxTests extends BaseTest {
    private CheckBox checkBox;

    @BeforeMethod
    public void goToCheckBox() {
        checkBox = new CheckBox(driver);
        checkBox.visit();
        Assert.assertTrue(isDisplayed(By.xpath("//h1[contains(text(), 'Check Box')]")));
    }

    @Test
    public void selectHome() {
        checkBox.selectCheckBox("Home");
        WebElement resultSection = checkBox.waitForResultSection();
        Assert.assertTrue(resultSection.isDisplayed());

        List<String> expectedList = Arrays.asList("home", "desktop", "notes", "commands", "documents", "workspace", "react", "angular", "veu", "office", "public", "private", "classified", "general", "downloads", "wordFile", "excelFile");
        List<String> actualSelected = checkBox.getActualSelected();
        Assert.assertEquals(actualSelected, expectedList);
    }

    @Test
    public void extendAllSelections() {
        checkBox.selectCheckBox("Home");
        WebElement resultSection = checkBox.waitForResultSection();
        Assert.assertTrue(resultSection.isDisplayed());

        checkBox.extendDropDown("Home");
        checkBox.extendDropDown("Desktop");
        checkBox.extendDropDown("Documents");
        checkBox.extendDropDown("WorkSpace");
        checkBox.extendDropDown("Office");
        checkBox.extendDropDown("Downloads");

    }

}
