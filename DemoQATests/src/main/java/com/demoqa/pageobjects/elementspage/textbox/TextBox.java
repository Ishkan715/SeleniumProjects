package com.demoqa.pageobjects.elementspage.textbox;

import com.demoqa.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TextBox extends BasePage {
    public TextBox(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://demoqa.com/text-box");
    }

    public void inputFullName(String fullName) {
        waitForElement(By.id("userName")).sendKeys(fullName);
    }

    public void inputEmail(String email) {
        waitForElement(By.id("userEmail")).sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress) {
        waitForElement(By.id("currentAddress")).sendKeys(currentAddress);
    }

    public void inputPermanentAddress(String permanentAddress) {
        waitForElement(By.id("permanentAddress")).sendKeys(permanentAddress);
    }

    public void submitForm(String fullName, String email, String currentAddress, String permanentAddress) {
        inputFullName(fullName);
        inputEmail(email);
        inputCurrentAddress(currentAddress);
        inputPermanentAddress(permanentAddress);

        driver.findElement(By.id("submit")).click();
    }

    public void confirmAfterSubmitInfo(String fullName, String email, String currentAddress, String permanentAddress) {
        waitForIsDisplayed((By.id("output")));
        WebElement outputSection = waitForElement(By.id("output"));

        Assert.assertTrue(outputSection.findElement(By.id("name")).getText().contains(fullName));
        Assert.assertTrue(outputSection.findElement(By.id("email")).getText().contains(email));
        Assert.assertTrue(outputSection.findElement(By.id("currentAddress")).getText().contains(currentAddress));
        Assert.assertTrue(outputSection.findElement(By.id("permanentAddress")).getText().contains(permanentAddress));
    }

    public void emptyFormValidation() {
        driver.findElement(By.id("submit")).click();

        WebElement output = driver.findElement(By.id("output"));
        List<WebElement> childDivs = output.findElements(By.tagName("div"));

        Assert.assertEquals(childDivs.size(), 1, "'output' should contain exactly one child div");

        String childText = childDivs.get(0).getText().trim();
        Assert.assertTrue(childText.isEmpty(), "Child div inside 'output' should be empty");
    }

}
