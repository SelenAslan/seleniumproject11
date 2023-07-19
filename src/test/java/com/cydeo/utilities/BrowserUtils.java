package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtils {

    /*
       This method will accept int (in seconds) and execute Thread.sleep
       for given duration
        */
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedURL, String expectedTitle){

        for (String each : driver.getWindowHandles()) {

            driver.switchTo().window(each);

            System.out.println("Current URL: " +driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedURL)){
                break;
            }

        }

        //Assert: Title contains “expectedURL”
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }

}
