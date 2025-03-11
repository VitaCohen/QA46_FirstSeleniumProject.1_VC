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

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void findElementByTagName() {
        // find element  by tag name
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());


        WebElement a = driver.findElement(By.tagName("a"));
        System.out.println(a.getText());

        //find list of elements
        List<WebElement> a1 = driver.findElements(By.tagName("a"));
        System.out.println(a1.size());
    }

    @Test
    public void findElementBySimpleLocator() {
        //by id
        driver.findElement(By.id("city"));

        // by Class name
        driver.findElement(By.className("hide-div"));

        // by link text
        WebElement carWork = driver.findElement(By.linkText("Let the car work"));
        System.out.println(carWork.getText());

        // by particialLinkText
        driver.findElement(By.partialLinkText("car"));
    }

    @Test
    public void findElementByCssSelectorText() {
        //1.  tag name = css
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.tagName("h1"));

        // 2. id=> css(#)
        // driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        // 3. className => css(.)
        // driver.findElement(By.className("hide-div"));
        driver.findElement(By.cssSelector(".hide-div"));

        //4. [attribute = 'value']
        //driver.findElement(By.cssSelector("[href='\"/login?url=%2Fsearch']"));
        //5. contains->*
        driver.findElement(By.cssSelector("[href*='login']"));

        //6. start-> ^
        driver.findElement(By.cssSelector("[href^='/log']"));

        //7. end on-> $
        driver.findElement(By.cssSelector("[href$='search']"));

        // 10.03

        //8. tag + id
        driver.findElement(By.cssSelector("input#city"));

        //9. tag + class
        driver.findElement(By.cssSelector("div.search-card"));

        //10. tag + id+ [attribute='value']
        driver.findElement(By.cssSelector("input#city[type='text']"));


    }

//      // *[@attr='value']

    @Test
    public void findElementByXpath() {
        // tag -> xpath //tag
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));


        //id -> xpath //*[@id='value']
        // driver.findElement(By.id("#city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        // className -> //*[@class='value']
        // driver.findElement(By.className("hide-div"));
        driver.findElement(By.xpath("//div[@class='hide-div']"));

        // contains -> //*[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));

        // equal> //*[text()='FoolText']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));// укороченная запись

        // start -> //*[starts-with(@attr,'Text')]
        driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));

        // move up -> //*[@class='navigation-link']/..
        driver.findElement(By.xpath("//a[@class='navigation-link']/.."));

        // ||or ili and
        // driver.findElement(By.xpath("//a[@class='navigation-link ||']/.."));

        // parent-> "//name/parent::*")
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));

        //ancestor->//name/ancestor::*
        driver.findElement(By.xpath("//h1/ancestor::*")); // all
        driver.findElement(By.xpath("//h1/ancestor::div")); // 2 options
        driver.findElement(By.xpath("//h1/ancestor::div[2]")); // one option

        // folowing-sibling-> //name/following-sibling::brothersName"
        driver.findElement(By.xpath(" //h1/following-sibling::form"));

        //h1/preceding-sibling::* -> older brothers

        driver.findElement(By.xpath("//h2/preceding-sibling::*"));


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
