package com.cydeo.tests.day8_extra_tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T5_GasMileageCalculator {

    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get("https://www.calculator.net");
    }

    @Test
    public void gas_mileage_calculator_automation_test(){

        //3. Search for “gas mileage” using search box
        Driver.getDriver().findElement(By.name("calcSearchTerm")).sendKeys("gas mileage");

        //4. Click on the “Gas Mileage Calculator” link
        Driver.getDriver().findElement(By.xpath("//a[@href='/gas-mileage-calculator.html']")).click();

        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Gas Mileage Calculator"));

        //b. “Gas Mileage Calculator” label is displayed
        WebElement label = Driver.getDriver().findElement(By.xpath("(//h1)[1]"));
        Assert.assertTrue(label.isDisplayed());

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometer = Driver.getDriver().findElement(By.name("mucodreading"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer =  Driver.getDriver().findElement(By.name("mupodreading"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = Driver.getDriver().findElement(By.name("mugasputin"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = Driver.getDriver().findElement(By.name("mugasprice"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        WebElement calculateBtn = Driver.getDriver().findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        calculateBtn.click();

        //11. Verify mpg value is as expected:
        String actualResult = Driver.getDriver().findElement(By.xpath("//b[.='23.44 km/L  or 4.27  L/100 km ']")).getText();
        String expectedResult = "23.44 mpg";

        //Expected value: “23.44 mpg”

        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @AfterMethod
    public void teardownMethod(){
       Driver.getDriver().quit();
    }

}
