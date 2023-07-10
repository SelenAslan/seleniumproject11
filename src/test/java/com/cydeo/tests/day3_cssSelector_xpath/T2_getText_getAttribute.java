package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {

        //1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer

        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        String rememberMeText = rememberMe.getText();
        String expectedRememberMeText= "Remember me on this computer";

        if (rememberMeText.equals(expectedRememberMeText)){
            System.out.println("Label verification is PASSED!!");
        } else {
            System.out.println("Label verification is FAILED!!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        String forgotPasswordText = forgotPassword.getText();
        String expectedForgotPasswordText = "Forgot your password?";

        if (forgotPasswordText.equals(expectedForgotPasswordText)){
            System.out.println("Forgot password verification is PASSED!!");
        } else {
            System.out.println("expectedForgotPasswordText = " + expectedForgotPasswordText);
            System.out.println("forgotPasswordText = " + forgotPasswordText);
            System.out.println("Forgot password verification is FAILED!!");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualInHref = forgotPassword.getAttribute("href");

        if (actualInHref.contains(expectedInHref)){
            System.out.println("Href verification is PASSED!!");
        } else {
            System.out.println("actualInHref = " + actualInHref);
            System.out.println("expectedInHref = " + expectedInHref);
            System.out.println("Href verification is FAILED!!");
        }


        //driver.close();


    }
}
/*
TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
PS: Inspect and decide which locator you should be using to locate web
elements.
 */