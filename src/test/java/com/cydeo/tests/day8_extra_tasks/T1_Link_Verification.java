package com.cydeo.tests.day8_extra_tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class T1_Link_Verification {

    @Test
    public void smartbear_link_verification_test(){


        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");

        //4. Enter password: “test”
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");

        //5. Click to Login button
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();

        //6. Print out count of all the links on landing page
        List<WebElement> allTheLinks = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println(allTheLinks.size());

        //7. Print out each link text on this page
        for (WebElement each : allTheLinks) {
            System.out.println(each.getText());
        }


        //Driver.getDriver().close();
    }


}
