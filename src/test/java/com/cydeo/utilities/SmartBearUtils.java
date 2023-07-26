package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartBearUtils {


    public static void loginToSmartBear(WebDriver driver,String username, String password){


        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys(username);

        //4. Enter password: “test”
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys(password);

        //5. Click to Login button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();



    }
    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parametre
}
