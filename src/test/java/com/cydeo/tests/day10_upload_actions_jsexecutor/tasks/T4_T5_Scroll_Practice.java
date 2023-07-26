package com.cydeo.tests.day10_upload_actions_jsexecutor.tasks;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class T4_T5_Scroll_Practice {

    @Test
    public void scroll_practice_task(){

        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”


        //4- Scroll using Actions class “moveTo(element)” method
        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button


    }
}
