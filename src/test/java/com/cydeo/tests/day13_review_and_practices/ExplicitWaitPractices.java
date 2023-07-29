package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.ExplicitWaitPracticePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    //TC #2: Explicit wait practice
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/dynamic_controls




    //NOTE: FOLLOW POM

    ExplicitWaitPracticePage explicitWaitPracticePage;

    @BeforeMethod
    public void setup(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

        explicitWaitPracticePage = new ExplicitWaitPracticePage();

    }

    @Test
    public void remove_button_test(){

        //3- Click to “Remove” button

        explicitWaitPracticePage.removeButton.click();

        //4- Wait until “loading bar disappears”

        /*
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(explicitWaitPracticePage.loadingBar));
         */
        BrowserUtils.waitForInvisibilityOf(explicitWaitPracticePage.loadingBar);
        //5- Verify:
        //a. Checkbox is not displayed
        try {
            Assert.assertFalse(explicitWaitPracticePage.checkbox.isDisplayed());
        } catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

        //b. “It's gone!” message is displayed.
        Assert.assertTrue(explicitWaitPracticePage.message.isDisplayed());
        Assert.assertTrue(explicitWaitPracticePage.message.getText().equals("It's gone!"));
    }

    @Test
    public void enable_button_test(){

        //TC #3: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

        //3- Click to “Enable” button
        explicitWaitPracticePage.enableButton.click();


        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(explicitWaitPracticePage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(explicitWaitPracticePage.inputBox.isEnabled());

        //b. “It's enabled!” message is displayed.
        System.out.println(explicitWaitPracticePage.message.getText());

        Assert.assertTrue(explicitWaitPracticePage.message.getText().equals("It's enabled!"));

        //NOTE: FOLLOW POM



    }

}
