package com.demoqa.pageobjects.elementspage.subsections;

import com.demoqa.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WebTables extends BasePage {
    private By firstNameInputLocator = By.id("firstName");
    private By lastNameInputLocator = By.id("lastName");
    private By emailInputLocator = By.id("userEmail");
    private By ageInputLocator = By.id("age");
    private By salaryInputLocator = By.id("salary");
    private By departmentInputLocator = By.id("department");

    public WebTables(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://demoqa.com/webtables");
    }

    public int numberOfEntriesInTable() {
        WebElement tableBody = driver.findElement(By.className("rt-tbody"));
        List<WebElement> rows = tableBody.findElements(By.cssSelector("div[role='row']"));

        List<WebElement> filteredRows = rows.stream().filter(row -> {
                    List<WebElement> childDivs = row.findElements(By.tagName("div"));
                    return !childDivs.isEmpty() && !childDivs.get(0).getText().trim().isEmpty();
                })
                .collect(Collectors.toList());

        return filteredRows.size();
    }

    public void clickAddButton() {
        driver.findElement(By.id("addNewRecordButton")).click();
    }

    public void clickSubmitButton() {
        driver.findElement(By.id("submit")).click();
    }

    public void addNewEntry(String firstName, String lastName, String email, int age, int salary, String department) {
        clickAddButton();
        waitForElement(By.id("userForm"));

        driver.findElement(firstNameInputLocator).sendKeys(firstName);
        driver.findElement(lastNameInputLocator).sendKeys(lastName);
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(ageInputLocator).sendKeys(Integer.toString(age));
        driver.findElement(salaryInputLocator).sendKeys(Integer.toString(salary));
        driver.findElement(departmentInputLocator).sendKeys(department);

        clickSubmitButton();
    }

    public void clickActionButton(int performActionOnRow, String action) {
        List<WebElement> rowElement = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@role='row']"));
        WebElement actionButtonsGroup = rowElement.get(performActionOnRow).findElement(By.className("action-buttons"));
        WebElement actionButton = actionButtonsGroup.findElement(By.cssSelector("span[title='" + action + "']"));
        actionButton.click();
    }

    public void editEntry(int rowToEdit, String firstName, String lastName, String email, int age, int salary, String department) {
        clickActionButton(rowToEdit, "Edit");

        waitForElement(By.id("userForm"));

        driver.findElement(firstNameInputLocator).sendKeys(firstName);
        driver.findElement(lastNameInputLocator).sendKeys(lastName);
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(ageInputLocator).sendKeys(Integer.toString(age));
        driver.findElement(salaryInputLocator).sendKeys(Integer.toString(salary));
        driver.findElement(departmentInputLocator).sendKeys(department);

        clickSubmitButton();
    }

    public void deleteEntry(int rowToDelete) {
        clickActionButton(rowToDelete, "Delete");
    }

    public void searchEntry(String searchBy) {
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys(searchBy);
    }

}
