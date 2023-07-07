package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {
    /*
        IN THIS CLASS WE ARE SOLVING THE DAY2_TASK1

         */
    public static void main(String[] args) {

        //TC #1: Cydeo practice tool verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
        //driver.get("https://practice.cydeo.com");
        driver.navigate().to("https://practice.cydeo.com");

        //3. Verify URL contains
        String expectedURL = "cydeo";
        String currentURL = driver.getCurrentUrl();

        String result = (currentURL.contains(expectedURL))? "URL verification PASSED!" :"URL verification FAILED!!!";
        System.out.println(result);

        // 4. Verify title:
        //Expected: Practice
        String expectedTitle = "Practice";
        String currentTitle = driver.getTitle();

        String result2 = (currentTitle.equals(expectedTitle))? "Title verification PASSED!" : "Title verification FAILED!!!" ;
        System.out.println(result2);

        driver.close();
    }
}
