package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick {

    //TC #1: Double Click Test

    //NOTE: FOLLOW POM

    @Test
    public void t1_double_click_test(){

        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        DoubleClickPage doubleClickPage = new DoubleClickPage();

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame(doubleClickPage.iframe);

        //3. Double click on the text “Double-click me to change my text color.”
        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(doubleClickPage.textBeforeClick).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        Assert.assertTrue(doubleClickPage.textAfterClick.getAttribute("style").contains("red"));

    }

}
