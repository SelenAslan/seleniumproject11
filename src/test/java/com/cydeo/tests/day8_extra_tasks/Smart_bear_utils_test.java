package com.cydeo.tests.day8_extra_tasks;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.SmartBearUtils;
import org.testng.annotations.Test;

public class Smart_bear_utils_test {

    @Test
    public void smart_bear_utils_test(){

        SmartBearUtils.loginToSmartBear(Driver.getDriver(),"Tester","test");

    }
}
