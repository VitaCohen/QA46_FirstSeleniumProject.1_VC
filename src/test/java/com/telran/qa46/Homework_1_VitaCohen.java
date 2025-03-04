package com.telran.qa46;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_1_VitaCohen {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://seferisrael.co.il/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void openSeferTest(){
        System.out.println("Sefer was opened");
    }
    @AfterMethod(enabled = true)
    public void tearDown(){
        driver.quit();
    }

}

