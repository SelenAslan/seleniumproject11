package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory_2 {

        public static WebDriver getSite(String webSite, String browserType) {

            if (browserType.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(webSite);
                return driver;

            } else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(webSite);
                return driver;

            } else {
                System.out.println("Given browser type does not exist/or is not currently supported");
                System.out.println("Driver = null");
                return null;
            }

    }
}
