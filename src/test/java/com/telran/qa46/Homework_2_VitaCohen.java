package com.telran.qa46;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_2_VitaCohen {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void findElementBySimpleLocator() {
        driver.findElement(By.id("dialog-notifications-success"));
        System.out.println("By Simple locators \n1.dialog-notifications-success");
        driver.findElement(By.id("bar-notification"));
        System.out.println("2.bar-notification");
        driver.findElement(By.id("dialog-notifications-error"));
        System.out.println("3.dialog-notifications-error");

        driver.findElement(By.className("close"));
        System.out.println("4. Class name 1");
        driver.findElement(By.className("ajax-loading-block-window"));
        System.out.println("5. Class name 2");
        driver.findElement(By.className("header-links-wrapper"));
        System.out.println("6.header-links-wrapper");

        WebElement log = driver.findElement(By.linkText("Log in"));
        System.out.println("7. " + log.getText());
        WebElement w = driver.findElement(By.linkText("Wishlist"));
        System.out.println("8. " + w.getText());

        driver.findElement(By.partialLinkText("Books"));
        System.out.println("9. partial link text 1");
        driver.findElement(By.partialLinkText("Computers"));
        System.out.println("10. partial link text 2");

    }

    @Test
    public void findElementByCssSelectorText() {
        // 1; 2 tag name = css
        driver.findElement(By.tagName("strong"));
        driver.findElement(By.tagName("head"));

        // 3; 4 id=> css(#)
        driver.findElement(By.cssSelector("#mob-menu-button"));
        driver.findElement(By.cssSelector("#dialog-notifications-success"));

        // 5; 6 className => css(.)
        driver.findElement(By.cssSelector(".header-logo"));
        driver.findElement(By.cssSelector(".cart-label"));

        //7. [attribute = 'value']
        driver.findElement(By.cssSelector("[href='/Content/jquery-ui-themes/smoothness/jquery-ui-1.10.3.custom.min.css']"));

        //8. contains->*
        driver.findElement(By.cssSelector("[href*='Content']"));

        //9. start-> ^
        driver.findElement(By.cssSelector("[href^='/Plugins']"));

        //10. end on-> $
        driver.findElement(By.cssSelector("[href$='cart']"));


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
