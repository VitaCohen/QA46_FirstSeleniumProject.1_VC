package com.telran.qa46;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TabelTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

 @Test
 public void findElementTableWithCssTest(){
        //print number of row(ryad)
     List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
     System.out.println(rows.size());
     for (WebElement el: rows){
         System.out.println(el.getText());
         System.out.println("**************");
         // get row 4(Mexica)
        WebElement row4 = driver.findElement(By.cssSelector("tr:nth-child(4)"));
         // xpath -> //tr[4]
         System.out.println(row4.getText());
         //get first item in row
         WebElement item1 = driver.findElement(By.cssSelector("tr:nth-child(7) td:nth-child(1)"));
         System.out.println(item1.getText());
         System.out.println("***************");

         // get last element
         WebElement canada = driver.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
         System.out.println(canada.getText());


    }
 }



    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

}
