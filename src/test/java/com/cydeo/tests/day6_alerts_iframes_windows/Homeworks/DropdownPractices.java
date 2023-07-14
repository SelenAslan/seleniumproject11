package com.cydeo.tests.day6_alerts_iframes_windows.Homeworks;

import com.cydeo.utilities.WebDriverFactory_2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownPractices {



    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        driver = WebDriverFactory_2.getSite("http://practice.cydeo.com/dropdown", "chrome");

    }

    @Test
    public void dropdown_task_5() throws InterruptedException {

        Select state = new Select(driver.findElement(By.xpath("//select[@id='state']")));


        //3. Select Illinois
        Thread.sleep(1000);
        state.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(1000);
        state.selectByValue("VA");

        //5. Select California
        Thread.sleep(1000);
        state.selectByIndex(5);


        //6. Verify final selected option is California.
        String exceptedState = "California";
        String actualState = state.getFirstSelectedOption().getText();
        Assert.assertEquals(actualState, exceptedState);

        //Use all Select options. (visible text, value, index)
    }

    @Test
    public void dropdown_task_6() {

        //3. Select “December 1st, 1923” and verify it is selected.
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        // Select year using : visible text
        year.selectByVisibleText("1924");

        //Select month using : value attribute
        month.selectByValue("11");

        //Select day using : index number
        day.selectByIndex(0);

        //creating axpected values

        String expectedYear = "1924";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values

        String actualYear = year.getFirstSelectedOption().getText();
        String actualMonth = month.getFirstSelectedOption().getText();
        String actualDay = day.getFirstSelectedOption().getText();

        //creat assertions

        Assert.assertEquals(actualDay, expectedDay);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertTrue(actualYear.equals(expectedYear));

    }

    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }

}
