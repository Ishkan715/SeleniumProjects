package com.demoqa.tests.elementspagetests.subsectionstests;

import com.demoqa.pageobjects.elementspage.subsections.TextBox;
import com.demoqa.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {
    private TextBox textBox;

    @BeforeMethod
    public void goToTextBox() {
        textBox = new TextBox(driver);
        textBox.visit();
        confirmPageLoadedUsingTitle("h1" , "Text Box");
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
