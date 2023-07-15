package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory_2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T5_Windows_Practice {

    WebDriver driver;
    @BeforeClass
    public void setupMethod(){


        //TC #5: Window Handle practice
        //1. Create a new class called: T5_WindowsPractice
        //2. Create new test and make setups
        //3. Go to : https://practice.cydeo.com/windows

        driver = WebDriverFactory_2.getSite("https://practice.cydeo.com/windows", "chrome");

    }

    @Test
    public void multiple_windows_practice(){

        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        System.out.println("Title before click:" + actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();



        //6. Switch to new Window.
        for (String each : driver.getWindowHandles()) {

            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());

        }
        //7. Assert: Title is “New Window”

        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitleAfterClick, actualTitle);

        System.out.println("Title after click:" + actualTitle);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

