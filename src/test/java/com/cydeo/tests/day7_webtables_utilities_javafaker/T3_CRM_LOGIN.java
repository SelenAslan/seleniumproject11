package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_CRM_LOGIN extends TestBase {





    @Test
    public void crm_login_test() {


        //TC #3: Login scenario
        //1. Create new test and make setups
        //2. Go to : http://login1.nextbasecrm.com/





        driver.get("https://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement inputUsername= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password
        WebElement inputPassword= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement LogInButton= driver.findElement(By.xpath("//input[@value='Log In']"));
        LogInButton.click();


        BrowserUtils.verifyTitle(driver, "(1) Portal");

    }


    @Test
    public void crm_login_test_2 () {


        //TC #3: Login scenario
        //1. Create new test and make setups
        //2. Go to : http://login1.nextbasecrm.com/


        driver.get("https://login1.nextbasecrm.com/");


        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);

        BrowserUtils.verifyTitle(driver, "(1) Portal");

    }

    @Test
    public void crm_login_test_3 () {


        //TC #3: Login scenario
        //1. Create new test and make setups
        //2. Go to : http://login1.nextbasecrm.com/


        driver.get("https://login1.nextbasecrm.com/");


        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver, "helpdesk1@cydeo.com", "UserUser");

        BrowserUtils.verifyTitle(driver, "(1) Portal");

    }
}
