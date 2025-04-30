package com.demoqa.tests.elementspagetests.subsectionstests;

import com.demoqa.pageobjects.elementspage.subsections.RadioButton;
import com.demoqa.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RadioButtonTests extends BaseTest {
    private RadioButton radioButton;

    @BeforeMethod
    public void goToRadioButton() {
        radioButton = new RadioButton(driver);
        radioButton.visit();
        Assert.assertTrue(isDisplayed(By.xpath("//h1[contains(text(), 'Radio Button')]")));
    }

    @Parameters({"selection"})
    @Test
    public void selectOption(String selection) {
        radioButton.selectOption(selection);
        WebElement selectedOption = radioButton.waitForSectedOptionSection();
        Assert.assertTrue(selectedOption.getText().equals(selection));
    }

    @Test
    public void shouldNotBeAbleToSelectNo() {
        WebElement noOptionLabel = driver.findElement(By.cssSelector("label[for='noRadio']"));
        Assert.assertTrue(noOptionLabel.getAttribute("class").contains("disabled"));
        noOptionLabel.click();
        Assert.assertTrue(driver.findElements(By.className("mt-3")).isEmpty());
    }
}
