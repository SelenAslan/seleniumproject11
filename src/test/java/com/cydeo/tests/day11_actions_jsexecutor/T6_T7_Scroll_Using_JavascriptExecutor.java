package com.cydeo.tests.day11_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T6_T7_Scroll_Using_JavascriptExecutor {

    @Test
    public void scroll_test6() throws InterruptedException {

       //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //3- Use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //a. 750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,750)");
            Thread.sleep(1000);
        }

        //b. 750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,-750)");
            Thread.sleep(1000);
        }

        //JavaScript method to use : window.scrollBy(0,0)


    }

    @Test
    public void scroll_test7(){
        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        // 2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");


        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[@target='_blank']"));

        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);

        //4- Scroll up to “Home” link
        //5- Use below provided JS method only
        //JavaScript method to use :
        //Note: You need to locate the links as web
    }

}
