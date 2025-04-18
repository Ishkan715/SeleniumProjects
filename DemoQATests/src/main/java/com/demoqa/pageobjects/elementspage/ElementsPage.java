package com.demoqa.pageobjects.elementspage;

import com.demoqa.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://demoqa.com/elements");
    }
}
