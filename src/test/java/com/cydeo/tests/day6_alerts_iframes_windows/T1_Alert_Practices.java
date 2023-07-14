package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory_2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T1_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //TC #1: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts


        driver = WebDriverFactory_2.getSite("http://practice.cydeo.com/javascript_alerts", "chrome");

    }

    @Test
    public void alert_test1() throws InterruptedException {

        //3. Click to “Click for JS Alert” button
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickForJSAlert.click();

        Thread.sleep(1000);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));

        //Failure message will only be displayed if assertion fails: "Result text is NOT displayed."
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed.");

        String actualText = resultText.getText();
        String expectedText = "You successfully clicked an alert";

        Assert.assertTrue(actualText.equals(expectedText), "Actual result text is not as expected!!!");

    }

    @AfterMethod
    public void teardownMethod(){

        driver.close();
    }

}
