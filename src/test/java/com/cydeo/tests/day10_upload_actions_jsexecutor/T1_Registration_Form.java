package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form_test(){

        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_for
        //Driver.getDriver() --> driver
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        Faker faker = new Faker();

        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        String fakerFirstName = faker.name().firstName();
        inputFirstName.sendKeys(fakerFirstName);

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        String fakerUsername = faker.bothify("helpdesk###");
        inputUsername.sendKeys(fakerUsername);

        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(fakerUsername + "@email.com");

        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        String fakerPassword = faker.bothify("###???###");
        inputPassword.sendKeys(fakerPassword);

        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        String fakerPhoneNumber = faker.numerify("571-###-####");
        inputPhoneNumber.sendKeys(fakerPhoneNumber);

        //9. Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();


        //10.Enter date of birth
        WebElement inputDateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputDateOfBirth.sendKeys("12/01/2000");

        //11.Select Department/Office
        Select selectDepartment = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        selectDepartment.selectByIndex(faker.number().numberBetween(1,9));

        //12.Select Job Title
        Select selectJobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        selectJobTitle.selectByIndex(faker.number().numberBetween(1,8));

        //13.Select programming language from checkboxes
        WebElement selectProgrammingLanguage = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        selectProgrammingLanguage.click();

        //14.Click to sign up button
        WebElement signUpBtn = Driver.getDriver().findElement(By.xpath("//*[.='Sign up']"));
        signUpBtn.click();

        //15.Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//p"));

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = successMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

        //Note:
        //1. Use new Driver utility class and method
        //2. User JavaFaker when possible
        //3. User ConfigurationReader when it makes sense
    }

}
