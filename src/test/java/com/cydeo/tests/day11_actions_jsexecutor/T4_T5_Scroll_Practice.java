package com.cydeo.tests.day11_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_T5_Scroll_Practice {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void scroll_practice_task() throws InterruptedException {

        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"))).perform();
        Thread.sleep(2000);



    }


    @Test
    public void Test2() throws InterruptedException {

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        Driver.getDriver().get("https://practice.cydeo.com/");
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));
        actions.moveToElement(homeLink).click().perform();

        //actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        Thread.sleep(2000);

    }
}
