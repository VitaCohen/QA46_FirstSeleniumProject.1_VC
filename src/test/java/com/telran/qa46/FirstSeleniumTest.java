package com.telran.qa46;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {
    WebDriver driver;
    // structure of project:
    // before method -SetUp

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        // driver.get("https://www.google.com/"); without history

        // maximaze window of browser
        driver.manage().window().maximize();

        driver.navigate().to("https://ilcarro.web.app/search");

        //wait for all elements on the load before starting test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.google.com/");//with history
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    //test
    @Test
    public void openGoogleTest() {
        System.out.println("Google opened");
    }

    //after method - tearDown
    @AfterMethod(enabled = false)
    public void tearDown() {
        //driver.quit(); close all and browsers
        driver.close(); // close only one tab
    }


}
