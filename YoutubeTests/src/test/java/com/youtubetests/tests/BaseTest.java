package com.youtubetests.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }

    protected int generateRandomInt() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 10);
        return randomNum;
    }
}
