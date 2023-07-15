package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory_2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T4_iframe_practice {

    WebDriver driver;

    //@BeforeMethod
    @BeforeClass
    public void setupMethod(){


        //TC #4: Iframe practice
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make setups
        //3. Go to: https://practice.cydeo.com/iframe

        driver = WebDriverFactory_2.getSite("https://practice.cydeo.com/iframe", "chrome");

    }

    //@Ignore
    @Test
    public void iframe_test(){

        //We need to switch driver's focus to iframe
        //option #1- switching to iframe using id attribute value
        //driver.switchTo().frame("mce_0_ifr");
        //driver.switchTo().frame(0);

        //option #2- passing index number of iframe
        //driver.switchTo().frame(0);

        //option #3- locate as web element and pass in frame() method

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        //Locate the p tag
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed());



    }

}

