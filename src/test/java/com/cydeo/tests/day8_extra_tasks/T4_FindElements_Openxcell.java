package com.cydeo.tests.day8_extra_tasks;

import com.cydeo.utilities.WebDriverFactory_2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class T4_FindElements_Openxcell {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() throws InterruptedException {

        driver = WebDriverFactory_2.getSite("https://www.openxcell.com", "chrome");
        Thread.sleep(2000);

    }

    @Test
    public void countLinksAndVerifyExpectedNumber(){

        List<WebElement> allTheLinks = driver.findElements(By.tagName("a"));

        int actualLinkNumber = allTheLinks.size();
        System.out.println(actualLinkNumber);
        int expectedLinkNumber = 383;

        Assert.assertEquals(expectedLinkNumber, actualLinkNumber);

    }

    @Test
    public  void printTextOfLinks(){

        List<WebElement> allTheLinks = driver.findElements(By.tagName("a"));

        for (WebElement each : allTheLinks) {
            if (!each.getText().isEmpty()){
                System.out.println(each.getText());
            }
        }


    }

    @Test
    public void countNumberOfLinksDoesNotHaveText(){

        List<WebElement> allTheLinks = driver.findElements(By.tagName("a"));
        int counter = 0;
        for (WebElement each : allTheLinks) {
            if (each.getText().isEmpty()){
                counter++;
            }
        }
        System.out.println(counter);
    }
    @AfterMethod
    public void teardownMethod(){
        driver.quit();
    }

}
