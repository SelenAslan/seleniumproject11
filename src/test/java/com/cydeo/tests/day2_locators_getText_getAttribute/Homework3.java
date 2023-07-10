package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://google.com");

        driver.findElement(By.className("gb_v")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED!!");
        } else{
            System.out.println("Title verification FAILED!!");
        }

        driver.navigate().back();

        actualTitle = driver.getTitle();
        expectedTitle = "Google";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!!");
        } else{
            System.out.println("Title verification FAILED!!");
        }

    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */