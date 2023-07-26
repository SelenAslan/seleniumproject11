package com.cydeo.tests.day8_extra_tasks;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.SmartBearUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Smartbear_Order_Placing {

    @Test
    public void smartbear_order_placing_test(){

        //TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        SmartBearUtils.loginToSmartBear(Driver.getDriver(),"Tester","test");

        //6. Click on Order
        Driver.getDriver().findElement(By.xpath("//a[@href='Process.aspx']")).click();

        //7. Select familyAlbum from product, set quantity to 2
        Select familyAlbum = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        familyAlbum.selectByIndex(1);

        Faker faker = new Faker();

        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("3");

        //8. Click to “Calculate” button
        Driver.getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();

        //9. Fill address Info with JavaFaker


        //• Generate: name, street, city, state, zip code
        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(faker.name().fullName());
        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(faker.address().streetName());
        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(faker.address().cityName());
        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(faker.address().cityName());
        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(faker.numerify("######"));

        //10.Click on “visa” radio button
        Driver.getDriver().findElement(By.xpath("//input[@value='Visa']")).click();

        //11.Generate card number using JavaFaker
        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(faker.numerify("################"));

        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("02/26");

        //12.Click on “Process”
        Driver.getDriver().findElement(By.xpath("(//a)[5]")).click();

        //13.Verify success message “New order has been successfully added.”
        BrowserUtils.sleep(1);
        String actualSuccessMessage = Driver.getDriver().findElement(By.tagName("strong")).getText();
        String expectedSuccessMessage = "New order has been successfully added.";

        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

    }
}
