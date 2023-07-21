package com.cydeo.tests.day8_proporties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory_2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T4_Config_Practice {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {

        //We are getting the browserType dynamically from our configuration.properties file
       String browserType = ConfigurationReader.getProperty("browser");
       driver = WebDriverFactory_2.getSite("https://www.google.com", browserType);

    }

    @Test
    public void google_search_test(){


        //3- Write “apple” in search box
        WebElement googleSearchBox = driver.findElement(By.xpath("//textarea[@type='search']"));

        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle = "apple - Google'da Ara";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }
}