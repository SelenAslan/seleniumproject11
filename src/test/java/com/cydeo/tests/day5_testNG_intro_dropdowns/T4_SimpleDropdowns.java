package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory_2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T4_SimpleDropdowns {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        //TC#4: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory_2.getSite("https://practice.cydeo.com/dropdown", "chrome");

    }
    @Test
    public void simpleDropdownTest(){

        //3. Verify “Simple dropdown” default selected value is correct
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
        String actualSimpleDropdownText = currentlySelectedOption.getText();
        String expectedSimpleDropdownText = "Please select an option";

        //Expected: “Please select an option”
        Assert.assertEquals(actualSimpleDropdownText, expectedSimpleDropdownText);



        //4. Verify “State selection” default selected value is correct
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        WebElement currentlyStateSelection= stateDropdown.getFirstSelectedOption();
        String actualStateSelection = currentlyStateSelection.getText();
        String expectedStateSelection = "Select a State";


        //Expected: “Select a State”
        Assert.assertEquals(actualStateSelection, expectedStateSelection);




    }


}
