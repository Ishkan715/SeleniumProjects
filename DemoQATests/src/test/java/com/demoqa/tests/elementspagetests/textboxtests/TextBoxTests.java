package com.demoqa.tests.elementspagetests.textboxtests;

import com.demoqa.pageobjects.elementspage.textbox.TextBox;
import com.demoqa.tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {
    private TextBox textBox;

    @BeforeMethod
    public void goToTextBox() {
        textBox = new TextBox(driver);
        textBox.visit();
        Assert.assertTrue(isDisplayed(By.xpath("//h1[contains(text(), 'Text Box')]")));
    }

    @Parameters({"fullName", "email", "currentAddress", "permanentAddress"})
    @Test
    public void textBoxTest(String fullName, String email, String currentAddress, String permanentAddress) {
        textBox.submitForm(fullName, email, currentAddress, permanentAddress);
        textBox.confirmAfterSubmitInfo(fullName, email, currentAddress, permanentAddress);
    }

    @Test
    public void emptyTextBoxTest() {
        textBox.emptyFormValidation();
    }
}
