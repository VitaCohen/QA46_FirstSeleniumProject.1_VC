package com.telran.qa46;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_3_VitaCohen {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void findElementByXpathHW() {
        //1, 2 tag ->//tag
        driver.findElement(By.xpath("//head"));
        driver.findElement(By.xpath("//title"));


        //3, 4 //id -> //*[@id='value']
        driver.findElement(By.xpath("//*[@id='dialog-notifications-error']"));
        driver.findElement(By.xpath("//*[@id='dialog-notifications-error']"));

        //5, 6 className -> //*[@class='value']
        driver.findElement(By.xpath("//*[@class='master-wrapper-page']"));
        driver.findElement(By.xpath("//*[@class='cart-label']"));

        //7, 8 // contains -> //*[contains(.,'Text')]
        driver.findElement(By.xpath("//*[contains(.,'All rights reserved')]"));
        driver.findElement(By.xpath("//*[contains(.,'Welcome')]"));

        //9. equal> //*[text()='FoolText']
        driver.findElement(By.xpath("//*[text()='Do you like nopCommerce?']"));

        //10. start -> //*[starts-with(@attr,'Text')]
        driver.findElement(By.xpath("//*[starts-with(@content,'text')]"));

        //11. move up -> //*[@attr='value']/..
        driver.findElement(By.xpath("//*[@rel='stylesheet']/.."));

        //12. parent-> "//name/parent::*")
        driver.findElement(By.xpath("//ul/parent::*"));

        //13. ancestor->//name/ancestor::*
        driver.findElement(By.xpath("//ul/ancestor::*"));

        //14.folowing-sibling-> //name/following-sibling::brothersName"
        driver.findElement(By.xpath("//ul/following-sibling::div"));

        //15. name/preceding-sibling::*
        driver.findElement(By.xpath("//ul/preceding-sibling::*"));


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
