package com.cydeo.tests.day8_extra_tasks;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Smartbear_order_verification {

    @Test
    public void smartbear_order_verification_test(){

      //1. Open browser and login to Smartbear software
        SmartBearUtils.loginToSmartBear(Driver.getDriver(),"Tester","test");

        //2. Click on View all orders
        Driver.getDriver().findElement(By.xpath("(//a)[1]"));

        //3. Verify Susan McLaren has order on date “01/05/2010”
        String actualOrderDate = Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//tbody//tr[6]//td[5]")).getText();
        String expectedOrderDate = "01/05/2010";

        Assert.assertEquals(expectedOrderDate,actualOrderDate);
    }
}
